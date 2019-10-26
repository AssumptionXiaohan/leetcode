/**
 * Created by 79300 on 2019/10/25.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0].length==0) return 0;
        if(obstacleGrid[0][0]==1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //先把第一行和第一列的obstacle之前的内容变成1
        obstacleGrid[0][0] = 1;
        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0]==1){
                obstacleGrid[i][0] = 0;
            }else{
                obstacleGrid[i][0] = obstacleGrid[i-1][0];
            }
        }
        //j从1开始是因为起点已经被设置为1，不能被当成障碍看
        for(int j=1;j<n;j++){
            //如果碰见obstacle把obstacle置为0，且后面的都要是0
            if(obstacleGrid[0][j]==1){
                obstacleGrid[0][j] = 0;
            }else{
                obstacleGrid[0][j] = obstacleGrid[0][j-1];
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                //如果遇到的是障碍，置为0
                if(obstacleGrid[i][j]==1){
                    obstacleGrid[i][j]=0;
                }else{
                    obstacleGrid[i][j] = obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                }
            }
        }

        return obstacleGrid[m-1][n-1];
    }
}
