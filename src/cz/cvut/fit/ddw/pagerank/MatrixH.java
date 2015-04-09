package cz.cvut.fit.ddw.pagerank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixH extends MatrixPR {

    /**
     * Initializes matrix H based on passed input file representing the web
     * links graph.
     *
     * Input file format: Firts row contains the count of linked pages Each
     * following row represents one web page (a) and lists all links leading
     * from the page in the format x:y (where x is the index of the linked page
     * - counted from 0 - and y is the count of links leading from page a to
     * page x).
     *
     * Thus for two web pages linking to each other the inut file looks like
     * this: 2 1:1 0:1
     *
     * @param fileName
     * @throws java.lang.Exception
     */
    public MatrixH(String fileName) throws Exception {
        super();

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        int pocet_stranek = Integer.parseInt(br.readLine());
        Matrix H = new Matrix(pocet_stranek, pocet_stranek);

        for (int kdo = 0; kdo < pocet_stranek; kdo++) {
            String line = br.readLine();
            String[] linky = line.split(" ");
            int celkemLinku = 0;

            if (line.length() > 0) {
                for (int i = 0; i < linky.length; i++) {
                    String ref = linky[i];
                    String[] rr = ref.split(":");
                    int kam = Integer.parseInt(rr[0]);
                    int kolik = Integer.parseInt(rr[1]);
                    celkemLinku += kolik;

                    //System.out.println(kdo + " -> " + kam + " (" + kolik + "x)");

                    H.set(kdo, kam, kolik);
                }
            }

//            System.out.print(kdo + " -> ");
            if (celkemLinku == 0) {
                celkemLinku = 1; // kolik bude vždy 0
            }
            for (int kam = 0; kam < pocet_stranek; kam++) {
                double kolik = H.get(kdo, kam);
                double zlomek = kolik / celkemLinku;
                H.set(kdo, kam, zlomek);
//                System.out.print("(" + kolik + "/" + celkemLinku + ") ");

            }
//            System.out.println("");
        }

        matrix = H;

        initializePageRankVector();
    }
}
