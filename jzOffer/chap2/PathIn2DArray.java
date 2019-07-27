package jzOffer.chap2;

public class PathIn2DArray {
    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如下面矩阵

     a b t g
     c f c s
     j d e h

     包含一条字符串"bfce"的路径，但是矩阵中不包含"abfb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
     */

    /**
     * 分析：回溯算法
     *  这是一个可以用回朔法解决的典型题。首先，在矩阵中任选一个格子作为路径的起点。如果路径上的第i个字符不是ch，那么这个格子不可能处在路径上的
     * 第i个位置。如果路径上的第i个字符正好是ch，那么往相邻的格子寻找路径上的第i+1个字符。除在矩阵边界上的格子之外，其他格子都有4个相邻的格子。
     * 重复这个过程直到路径上的所有字符都在矩阵中找到相应的位置。
     * 　　由于回朔法的递归特性，路径可以被开成一个栈。当在矩阵中定位了路径中前n个字符的位置之后，在与第n个字符对应的格子的周围都没有找到第n+1个
     * 字符，这个时候只要在路径上回到第n-1个字符，重新定位第n个字符。
     * 　　由于路径不能重复进入矩阵的格子，还需要定义和字符矩阵大小一样的布尔值矩阵，用来标识路径是否已经进入每个格子。 当矩阵中坐标为（row,col）的
     * 格子和路径字符串中相应的字符一样时，从4个相邻的格子(row,col-1),(row-1,col),(row,col+1)以及(row+1,col)中去定位路径字符串中下一个字符
     * 如果4个相邻的格子都没有匹配字符串中下一个的字符，表明当前路径字符串中字符在矩阵中的定位不正确，我们需要回到前一个，然后重新定位。
     * 一直重复这个过程，直到路径字符串上所有字符都在矩阵中找到合适的位置
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[] marked = new boolean[matrix.length];
        //依次从每个点开始扫
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (hasPathTo(matrix,rows,cols,i,j,str,0,marked)){
                    return true;
                }
            }
        }
      return false;
    }

    private boolean hasPathTo(char[] matrix, int rows, int cols, int row, int col, char[] str, int len, boolean[] marked) {
        //计算矩阵索引在数组中位值
        int index = row*cols+col;
        if (row>=rows || col>=cols || row<0 || col<0 || str == null){
            return false;
        }else if (matrix[index] != str[len] || marked[index]){
            //不等于此索引的值或者标志位为true，表明已经遍历过
            return false;
        }
        if (len == str.length-1){
            //传入的数组到了最后，说明找到
            return true;
        }
        //此索引位置设true
        marked[index] = true;
        //递归上下左右
        if (hasPathTo(matrix,rows,cols,row,col-1,str,len+1,marked) || hasPathTo(matrix,rows,cols,row-1,col,str,len+1,marked) || hasPathTo(matrix,rows,cols,row,col+1,str,len+1,marked) || hasPathTo(matrix,rows,cols,row+1,col,str,len+1,marked)){
            return true;
        }
        //如果没找到下一个，则返回上一级，改变标志位，重新循环
        marked[index] = false;
        return false;
    }

    public static void main(String[] args) {
        PathIn2DArray path = new PathIn2DArray();
        char[] c = {'A','B','C','E','S','F','C','S','A','D','E','E'};
        char[] str = {'A','B','C','C','E','D'};
        System.out.println(path.hasPath(c,3,4,str
        ));
    }
}
