package com.test;

//import required
import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;
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
            getStatus(path);
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
            RevCommit call = git.commit().setMessage(message).call();
            
            ;
            
            // log info
            logger.info("Committed files with commit Id {}", call.getId().getName());
            // Get the status of the repository


        } catch (IOException | GitAPIException e) {
            logger.error("Exception occurred while committing files", e);
        }
    }

    //add a method to get the status of the repository
    public static void getStatus(String path) {
        // log info
        logger.info("Getting status of the repository");
        // Get the status of the repository
        try {
            Git git = Git.open(new File(path));
            Status status = git.status().call();

            // Print the status information
            System.out.println("Modified Files:");
            status.getModified().forEach(System.out::println);

            System.out.println("\nAdded Files:");
            status.getAdded().forEach(System.out::println);

            System.out.println("\nUntracked Files:");
            status.getUntracked().forEach(System.out::println);

            System.out.println("\nChanged Files:");
            status.getChanged().forEach(System.out::println);

            // log info
            logger.info("Got status of the repository");
        } catch (IOException | GitAPIException e) {
            logger.error("Exception occurred while getting status of the repository", e);
        }
    }

    // main method
    public static void main(String[] args) {
        // log info
        logger.info("Adding files to index");
        // call addFilesToIndex method
        addFilesToIndex("D:\\00_Trainings\\CTS\\CoPilot\\prac\\testgit");

        // call commit method
        commit("D:\\00_Trainings\\CTS\\CoPilot\\prac\\testgit", "Committing files");
        // log info
        logger.info("Committed files");
    }
    
}
