package com.ttt.serentity.study.generators;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenerateThemesEpicsFeatures
{
    private static final Logger logger = LoggerFactory.getLogger(GenerateThemesEpicsFeatures.class);

    public static void main(String[] args) {
        logger.trace("Working Directory: " + System.getProperty("user.dir"));
        GenerateThemesEpicsFeatures.generate();
    }

    private static int theme, epic, feature, scenario;
    private static String   requirements  = "src\\main\\resources\\com\\ttt\\serenity\\study";

//    private static String LOWER        = "abc";
//    private static String DIGIT        = "123";
//    private static String TILDE        = "t~d";

    private static String UPPER        = "XYZ";
    private static String CAMEL        = "caMel";
    private static String UNDERSCORE   = "u_n";
    private static String DASH         = "d-s";
    private static String COLON        = "c:n";
    private static String SINGLE_QUOTE = "\'sq\'";
    private static String DOUBLE_QUOTE = "\"dq\"";

    // Generated file names include 'feature' + index + ~, taking care of LOWER, DIGIT and TILDE
    // so no need to include them in the parts test arrays.
    private static String[] folderParts    = {UPPER, CAMEL, UNDERSCORE, DASH, SINGLE_QUOTE};
    private static String[] invalidFolderParts = {COLON, DOUBLE_QUOTE};
    private static String[] featureParts   = {UPPER, CAMEL, UNDERSCORE, DASH, COLON, SINGLE_QUOTE};
    private static String[] invalidFeatureParts = {DOUBLE_QUOTE};
    private static String[] scenarioParts  = {UPPER, CAMEL, UNDERSCORE, DASH, COLON, SINGLE_QUOTE, DOUBLE_QUOTE};


    private static void generate() {
        int index = 1;

        for( theme = 0; theme < folderParts.length; theme++ ) {
            for( epic = 0; epic < folderParts.length; epic++ ) {
                for( feature = 0; feature < featureParts.length; feature++ ) {
                    String id          = String.format("%03d", index);
                    String themeName   = String.format("theme%s ~ %s",   id, folderParts[theme]);
                    String epicName    = String.format("epic%s ~ %s",    id, folderParts[epic]);
                    String featureName = String.format("feature%s ~ %s", id, featureParts[feature]);
                    String filename    = String.format("%s\\%s\\%s\\%s.feature", requirements, themeName, epicName, featureName );

                    logger.trace("Generating theme, epic, feature: " + filename);
                    File file = new File(filename);
                    File parent = file.getParentFile();
                    if(!parent.exists() && !parent.mkdirs()) {
                        throw new RuntimeException("Couldn't create folders: " + file);
                    }
                    WriteFeature(filename, featureName);
                    for( scenario = 0; scenario < scenarioParts.length; scenario++ ) {
                        String scenarioName = String.format("%02d ~ %s", scenario, scenarioParts[scenario]);
                        WriteScenario(scenarioName);
                    }

                    index++;
                }
            }
        }
    }

    private static File featureFile;
    private static void WriteFeature(String filename, String featureName) {
        try {
            featureFile = new File(filename);
            try {
                // Delete if exits and regenerate
                FileUtils.forceDelete(featureFile);
            } catch(Exception e) {
                // ignore
            }

            String content = FileUtils.readFileToString(new File(GenerateThemesEpicsFeatures.class.getResource("/templates/feature.template").toURI()), "UTF-8");
            content = content.replaceAll("\\{feature_name\\}", featureName);

            FileUtils.writeStringToFile(featureFile, content, "UTF-8");
         } catch (Exception e) {
            throw new RuntimeException("Couldn't create file: " + filename);
         }
    }

    private static void WriteScenario(String scenarioName) {
        try {
            String scenario = FileUtils.readFileToString(new File(GenerateThemesEpicsFeatures.class.getResource("/templates/scenario.template").toURI()), "UTF-8");
            scenario = scenario.replaceAll("\\{scenario_name\\}", scenarioName);
            FileUtils.writeStringToFile(featureFile, scenario, "UTF-8", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

