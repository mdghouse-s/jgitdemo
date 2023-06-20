package com.test;

//import required classes
import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;

public class AddFiles {
    public static void main(String[] args) {
        System.out.println("AddFiles");
        // Add the files to git repo using Jgit
        Git git = null;
        try {
            git = Git.open(new File("C:\\Users\\mdghouse\\Desktop\\jgitdemo"));
            git.add().addFilepattern(".").call();
        } catch (IOException | GitAPIException e) {
            e.printStackTrace();
        }

        // commit to local repo using Jgit. with exception handling
        try {
            git.commit().setMessage("Added files").call();
            System.out.println("Done");
        } catch (GitAPIException e) {
            e.printStackTrace();
        }

        Iterable<RevCommit> logs;
        try {
            logs = git.log()
                    .call();
            int count = 0;
            for (RevCommit rev : logs) {
                System.out.println("Commit: " + rev /*
                                                     * + ", name: " + rev.getName() + ", id: " + rev.getId().getName()
                                                     */);
                count++;
            }
        } catch (GitAPIException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
