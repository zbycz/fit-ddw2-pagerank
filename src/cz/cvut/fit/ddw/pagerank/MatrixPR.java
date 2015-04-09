package cz.cvut.fit.ddw.pagerank;

/**
 * Represents a general matrix for page rank computation. Pass either matrix H, S or G
 * to the constructor to perform the computation.
 *
 */
public abstract class MatrixPR {
    protected Matrix matrix;
    protected Matrix pageRankVector;
    
    public MatrixPR() {}
    
    public void initializePageRankVector(){
        pageRankVector = new Matrix(1, matrix.getM());
        for (int i = 0; i < pageRankVector.getN(); i++)
            pageRankVector.set(0, i, 1/(double)pageRankVector.getN());
    }
    
    
    public Matrix getMatrix() {
        return matrix;
    }
    
    
    /**
     * Counts PageRank based on links graph represented by {@link #matrix}.
     * 
     * @param iterations Number of iterations to compute final value of PageRank.
     */
    public void countPr(int iterations) {
        System.out.println("PageRank init");
        pageRankVector.show();
        System.out.println("=============================================");
        
        for (int i = 1; i <= iterations; i++) {
            System.out.println("PageRank Iteration " + i);
            countPageRankIteration();
            pageRankVector.show();
            checkSum();
            System.out.println("=============================================");
        }
    }
    
    private void checkSum() {
        double sum = 0;
        for (int i = 0; i < pageRankVector.getN(); i++)
            sum += pageRankVector.get(0, i);
        System.out.println("Sum: " + sum);
    }
    
    /**
     * Computes values of PageRank vector for the next iteration.
     */
    private void countPageRankIteration() {
        pageRankVector = pageRankVector.times(matrix);
    }
}
