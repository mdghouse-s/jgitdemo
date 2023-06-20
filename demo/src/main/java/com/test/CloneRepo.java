package com.test;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.Status;

// import required classes
import java.io.File;
import org.eclipse.jgit.api.errors.GitAPIException;

//add slf4j logger for logging
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CloneRepo {
    // create logger
    private static final Logger logger = LoggerFactory.getLogger(CloneRepo.class);

    public static void main(String[] args) {
        // log info
        logger.info("Cloning repo");

        // clone a respotory using JGit
        try {
            Git git = Git.cloneRepository()
                    .setURI("https://github.com/mdghouse-s/jgitdemo.git")
                    .setDirectory(new File("D:\\00_Trainings\\CTS\\CoPilot\\prac\\sampleclone"))
                    // .setCloneAllBranches(true)
                    .call();

                    // log info
                    logger.info("Cloned repo");

        } catch (GitAPIException e) {
            logger.error("Exception occurred while cloning repo", e);
        }
    }
}
