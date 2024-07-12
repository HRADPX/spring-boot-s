package com.kuaishou.springboot.test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-11-29
 */
public class PomDependencyDemo {

    private static final List<String> EXCLUDE_PROJECT = ImmutableList.of();

    public static void main(String[] args) throws IOException {


//        12468190528,12145644270
        int i = "creative_profile_GDT_MEDIA_12145644270".hashCode();
        System.out.println(i);


        File path = new File("src/main/pomxmls");
        File[] directories = Objects.requireNonNull(path.listFiles());

        Set<String> dependencies = Sets.newHashSet();
        List<Set<String>> projectDependencyList = Lists.newArrayList();

        for (File directory : directories) {
            if (EXCLUDE_PROJECT.contains(directory.getName())) {
                continue;
            }
            Set<String> directoryDependencies = readDependencies(directory);
            dependencies.addAll(directoryDependencies);
            projectDependencyList.add(directoryDependencies);
            System.out.println("【" + directory.getName() + "】工程直接依赖的个数：" + directoryDependencies.size());
        }
        System.out.println("-----------------------------------------");
        System.out.println(directories.length + "个工程依赖个数：" + dependencies.size());

        Collection<String> commons = projectDependencyList.get(0);

        for (Set<String> dependencyList : projectDependencyList) {
            if (dependencyList.isEmpty()) {
                continue;
            }
            commons = CollectionUtils.intersection(commons, dependencyList);
        }
        System.out.println(directories.length + "个工程公共依赖个数：" + commons.size());
        System.out.println(deserialize(commons));
    }

    private static Set<String> readDependencies(File directory) throws IOException {
        Collection<File> files = FileUtils.listFiles(directory, new String[] {"xml"}, true);
        Set<String> dependencies = Sets.newHashSet();
        for (File file : files) {
            List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
            Set<String> subDependencies = parsePomXml(lines);
            dependencies.addAll(subDependencies);
        }
        return dependencies;
    }

//    public static void main(String[] args) throws IOException {
//
//        List<String> stringList = FileUtils
//                .readLines(new File("src/main/pomxmls/creative/kwaishop-dependency-analyze-component.xml"),
//                        StandardCharsets.UTF_8);
//        System.out.println(parsePomXml(stringList));
//    }

    private static Set<String> parsePomXml(List<String> pomLines) {

        Set<String> dependencies = Sets.newHashSet();
        boolean hasComment = false;
        boolean start = false;

        List<String> current = Lists.newArrayList();


        for (String line : pomLines) {
            if (StringUtils.isBlank(StringUtils.trim(line))) {
                continue;
            }
            if (StringUtils.startsWith(StringUtils.trim(line), "<!--")
                    && StringUtils.endsWith(StringUtils.trim(line), "-->")) {
                continue;
            }
            if (StringUtils.startsWith(StringUtils.trim(line), "<!--") && !hasComment) {
                hasComment = true;
                continue;
            }
            if (StringUtils.endsWith(StringUtils.trim(line), "-->") && hasComment) {
                hasComment = false;
                continue;
            }
            if (hasComment) {
                continue;
            }
            if (StringUtils.startsWith(StringUtils.trim(line), "<dependencies>")) {
                start = true;
                continue;
            }
            if (StringUtils.endsWith(StringUtils.trim(line), "</dependencies>")) {
                break;
            }
            if (!start) {
                continue;
            }
            if (StringUtils.startsWith(StringUtils.trim(line), "<dependency>")
                    && StringUtils.startsWith(StringUtils.trim(line), "</dependency>")) {
                dependencies.add(parseDependency(line));
                continue;
            }
            if (StringUtils.startsWith(StringUtils.trim(line), "<dependency>")) {
                if (!current.isEmpty()) {
                    current.clear();
                }
            }
            current.add(StringUtils.trim(line));
            if (StringUtils.endsWith(StringUtils.trim(line), "</dependency>")) {
                if (!current.contains("<scope>test</scope>")) {
                    dependencies.add(parseDependency(String.join("", current)));
                }
                current.clear();
            }
        }
        return dependencies;
    }

    public static String parseDependency(String origin) {
        origin = StringUtils.trim(origin);
        String first = subString(origin, "<groupId>", "</groupId>");
        String second = subString(origin, "<artifactId>", "</artifactId>");
        return String.format("%s:%s", first, second);
    }

    private static String subString(String origin, String start, String end) {

        return StringUtils.substring(origin,
                StringUtils.indexOf(origin, start) + start.length(),
                StringUtils.indexOf(origin, end));
    }

    private static String deserialize(Collection<String> dependencies) {
        StringBuilder result = new StringBuilder("<dependencies>\n");
        for (String dependency : dependencies) {
            String[] pair = StringUtils.split(dependency, ":");
            result.append("\t<dependency>\n");
            result.append("\t\t<groupId>").append(pair[0]).append("</groupId>\n");
            result.append("\t\t<artifactId>").append(pair[1]).append("</artifactId>\n");
            result.append("\t</dependency>\n");
        }
        return result.append("</dependencies>").toString();
    }

}
