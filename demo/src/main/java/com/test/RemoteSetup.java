package com.test;

//import required classes
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.URIish;

//Add logger import
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RemoteSetup {

    // create logger
    private static final Logger logger = LoggerFactory.getLogger(RemoteSetup.class);
    //create a static method named addRemote to add a remote to a git repo using JGit
    // method should take the url of the repo as parameter
    public static void addRemote(String localPath, String remoteUrl) throws URISyntaxException {
        // log info
        logger.info("Adding remote");
        // add remote to a git repo using JGit
        try {
            Git git = Git.open(new File(localPath));
            git.remoteAdd()
                    .setName("origin")
                    .setUri(new URIish(remoteUrl))
                    .call();
            // log info
            logger.info("Added remote");
        } catch (IOException | GitAPIException e) {
            logger.error("Exception occurred while adding remote", e);
        }
    }
    //create a static method named removeRemote to remove a remote from a git repo using JGit
    // method should take the name of the remote as parameter
    public static void removeRemote(String localPath, String remoteName) {
        // log info
        logger.info("Removing remote");
        // remove remote from a git repo using JGit
        try {
            Git git = Git.open(new File(localPath));
            git.remoteRemove()
                    .setRemoteName(remoteName)
                    .call();
            // log info
            logger.info("Removed remote");
        } catch (IOException | GitAPIException e) {
            logger.error("Exception occurred while removing remote", e);
        }
    }

    // main method
    public static void main(String[] args) throws URISyntaxException {
        // log info
        logger.info("Adding remote");
        // call addRemote method
        addRemote("D:\\00_Trainings\\CTS\\CoPilot\\prac\\testgit", "https://github.com/mdghouse-s/jgitdemo.git");
        // log info
        logger.info("Added remote");
    
    }

}
