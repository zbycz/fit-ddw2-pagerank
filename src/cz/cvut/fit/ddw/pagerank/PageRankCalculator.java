package cz.cvut.fit.ddw.pagerank;


public class PageRankCalculator {
    
    /**
     * @param args Expects following arguments 0 - input file, 1 - number of iterations to compute PageRank, 2 - dumping factor
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.out.println("Wrong input parameters - required 3 parameters");
            System.out.println("Usage: java -jar inputFile rounds dumpingFactor");
            
            System.exit(1);
        }
        
        String inputFile = args[0];
        int rounds = new Integer(args[1]);
        double dumpingFactor = new Double(args[2]);
        
        System.out.println("== Matrix H calculation ==");
        MatrixH h = calculateWithMatrixH(inputFile, rounds);
        System.out.println("==========================");
        System.out.println("== Matrix S calculation ==");
        MatrixS s = calculateWithMatrixS(h, rounds);
        System.out.println("==========================");
        System.out.println("== Matrix G calculation ==");
        calculateWithMatrixG(s, rounds, dumpingFactor);
    }
    
    private static MatrixH calculateWithMatrixH(String inputFile, int rounds) throws Exception {
        MatrixH h = new MatrixH(inputFile);
        printMatrix(h.getMatrix());
        h.countPr(rounds);
        
        return h;
    }
    
    private static MatrixS calculateWithMatrixS(MatrixH h, int rounds) {
        MatrixS s = new MatrixS(h);
        printMatrix(s.getMatrix());
        s.countPr(rounds);
        
        return s;
    }
    
    private static void calculateWithMatrixG(MatrixS s, int rounds, double dumpingFactor) {
        MatrixG g = new MatrixG(s, dumpingFactor);
        printMatrix(g.getMatrix());
        g.countPr(rounds);
    }
    
    private static void printMatrix(Matrix matrix) {
        System.out.println("=============================================");
        matrix.show();
        System.out.println("=============================================");
    }

}
