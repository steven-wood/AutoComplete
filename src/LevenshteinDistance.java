/**
 * Created by Steven on 7/25/2017.
 */
public class LevenshteinDistance {
    public static int editCount(String n, String m){
        int[][] counts = new int[n.length()+1][m.length()+1];
        for(int i=0;i<=Math.max(n.length(), m.length());i++){
            if(i<=n.length())counts[i][0] = i;
            if(i<=m.length())counts[0][i] = i;
        }
        for(int i=1;i<n.length()+1;i++)
            for(int j=1;j<m.length()+1;j++){
                int subWeight = (n.charAt(i-1) != m.charAt(j-1))?2:0;
                counts[i][j] = Math.min(counts[i-1][j-1]+subWeight, Math.min(counts[i-1][j]+1, counts[i][j-1]+1));
            }
        return counts[n.length()][m.length()];
    }
}
