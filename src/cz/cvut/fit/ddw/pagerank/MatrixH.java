package cz.cvut.fit.ddw.pagerank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixH extends MatrixPR {
    
    /**
     * Initializes matrix H based on passed input file representing the web links graph.
     * 
     * Input file format:
     * Firts row contains the count of linked pages
     * Each following row represents one web page (a) and lists all links leading from the page
     * in the format x:y (where x is the index of the linked page - counted from 0 - and y
     * is the count of links leading from page a to page x).
     * 
     * Thus for two web pages linking to each other the inut file looks like this:
     * 2
     * 1:1
     * 0:1
     */
    public MatrixH(String fileName) {
        // TODO Implement matrix H initialiaztion
        // super(matrixH);
    }
}