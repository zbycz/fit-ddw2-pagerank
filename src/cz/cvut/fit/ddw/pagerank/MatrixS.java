package cz.cvut.fit.ddw.pagerank;

public class MatrixS extends MatrixPR {

    /**
     * Initializes matrix S based on passed matrix H.
     */
    public MatrixS(MatrixH matrixH) {
        super();
        Matrix H = matrixH.getMatrix();
        Matrix S = new Matrix(H);

        for (int i = 0; i < S.getM(); i++) {
            boolean nulovy = true;
            for (int j = 0; j < S.getM(); j++) {
                if (S.get(i, j) > 0) {
                    nulovy = false;
                }
            }

            if (nulovy) {
                for (int j = 0; j < S.getM(); j++) {
                    S.set(i, j, 1 / (double) S.getM());
                }
            }
        }

        matrix = S;
        initializePageRankVector();

    }

}
