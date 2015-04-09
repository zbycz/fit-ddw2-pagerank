package cz.cvut.fit.ddw.pagerank;

public class MatrixG extends MatrixPR {

    /**
     * Initializes matrix G based on passed matrix S and dumping factor.
     */
    public MatrixG(MatrixS matrixS, double dumpingFactor) {
        super();
        Matrix S = matrixS.getMatrix();
        Matrix G = new Matrix(S);

        G.scalarTimes(dumpingFactor);

        double n = G.getM();
        G.eachPlus((1 - dumpingFactor) * (1 / n));

        matrix = G;
        initializePageRankVector();

    }
}
