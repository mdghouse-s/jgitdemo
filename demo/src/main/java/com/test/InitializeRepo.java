package com.test;

//import required classes
import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

//Add logger import 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitializeRepo {

    // create logger
    private static final Logger logger = LoggerFactory.getLogger(InitializeRepo.class);

    // static method name initializeRepo to initialize a git repo
    public static void initializeRepo(String path) {
        try {
            Git git = Git.init().setDirectory(new File(path)).call();
            // log info
            logger.info("Initialized repo : " + git.getRepository().getDirectory());

        } catch (IllegalStateException | GitAPIException e) {
            // log error
            logger.error("Exception occurred while initializing repo", e);

        }
    }

    // main method
    public static void main(String[] args) {
        // log info
        logger.info("Initializing repo");

        // call initializeRepo method
        initializeRepo("D:\\00_Trainings\\CTS\\CoPilot\\prac\\testgit");

        // log info
        logger.info("Initialized repo");
    }

}
