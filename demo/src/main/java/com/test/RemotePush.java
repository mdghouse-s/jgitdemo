package com.test;


//import required classes
import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;


//Add logger import
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RemotePush {

    //create logger
    private static final Logger logger = LoggerFactory.getLogger(RemotePush.class);

    //method push to push files to remote repo
    public static void push(String path, String remoteUrl, String username, String password) {
        // log info
        logger.info("Pushing files to remote repo");
        // push files to remote repo
        try {
            Git git = Git.open(new File(path));
            git.push().setRemote(remoteUrl).setCredentialsProvider(new UsernamePasswordCredentialsProvider(username, password)).call();
            // log info
            logger.info("Pushed files to remote repo");
        } catch (IOException | GitAPIException e) {
            logger.error("Exception occurred while pushing files to remote repo", e);
        }
    }

    //method pushAuth to push files to remote repo    
    public static void main(String[] args) {

    

    }

}
