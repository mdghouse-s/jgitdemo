package com.test;

//import required
import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

//Add logger import
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddCommit {

    // create logger
    private static final Logger logger = LoggerFactory.getLogger(AddCommit.class);
    //method addFilesToIndex to add files to index
    public static void addFilesToIndex(String path) {
        // log info
        logger.info("Adding files to index");
        // add files to index
        try {
            Git git = Git.open(new File(path));
            git.add().addFilepattern(".").call();
            // log info
            logger.info("Added files to index");
        } catch (IOException | GitAPIException e) {
            logger.error("Exception occurred while adding files to index", e);
        }
    }

    //method commit to commit files to repo
    public static void commit(String path, String message) {
        // log info
        logger.info("Committing files");
        // commit files to repo
        try {
            Git git = Git.open(new File(path));
            git.commit().setMessage(message).call();
            // log info
            logger.info("Committed files");
        } catch (IOException | GitAPIException e) {
            logger.error("Exception occurred while committing files", e);
        }
    }

    // main method
    public static void main(String[] args) {
        // log info
        logger.info("Adding files to index");
        // call addFilesToIndex method
        addFilesToIndex("D:\\00_Trainings\\CTS\\CoPilot\\prac\\testgit");
        // log info
        logger.info("Added files to index");
        // log info
        logger.info("Committing files");
        // call commit method
        commit("D:\\00_Trainings\\CTS\\CoPilot\\prac\\testgit", "Committing files");
        // log info
        logger.info("Committed files");
    }
    
}