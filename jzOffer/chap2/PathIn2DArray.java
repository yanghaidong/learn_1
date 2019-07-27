package jzOffer.chap2;

public class PathIn2DArray {
    /**
     * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
     * ���һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ� �����������

     a b t g
     c f c s
     j d e h

     ����һ���ַ���"bfce"��·�������Ǿ����в�����"abfb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
     */

    /**
     * �����������㷨
     *  ����һ�������û�˷������ĵ����⡣���ȣ��ھ�������ѡһ��������Ϊ·������㡣���·���ϵĵ�i���ַ�����ch����ô������Ӳ����ܴ���·���ϵ�
     * ��i��λ�á����·���ϵĵ�i���ַ�������ch����ô�����ڵĸ���Ѱ��·���ϵĵ�i+1���ַ������ھ���߽��ϵĸ���֮�⣬�������Ӷ���4�����ڵĸ��ӡ�
     * �ظ��������ֱ��·���ϵ������ַ����ھ������ҵ���Ӧ��λ�á�
     * �������ڻ�˷���ĵݹ����ԣ�·�����Ա�����һ��ջ�����ھ����ж�λ��·����ǰn���ַ���λ��֮�������n���ַ���Ӧ�ĸ��ӵ���Χ��û���ҵ���n+1��
     * �ַ������ʱ��ֻҪ��·���ϻص���n-1���ַ������¶�λ��n���ַ���
     * ��������·�������ظ��������ĸ��ӣ�����Ҫ������ַ������Сһ���Ĳ���ֵ����������ʶ·���Ƿ��Ѿ�����ÿ�����ӡ� ������������Ϊ��row,col����
     * ���Ӻ�·���ַ�������Ӧ���ַ�һ��ʱ����4�����ڵĸ���(row,col-1),(row-1,col),(row,col+1)�Լ�(row+1,col)��ȥ��λ·���ַ�������һ���ַ�
     * ���4�����ڵĸ��Ӷ�û��ƥ���ַ�������һ�����ַ���������ǰ·���ַ������ַ��ھ����еĶ�λ����ȷ��������Ҫ�ص�ǰһ����Ȼ�����¶�λ��
     * һֱ�ظ�������̣�ֱ��·���ַ����������ַ����ھ������ҵ����ʵ�λ��
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[] marked = new boolean[matrix.length];
        //���δ�ÿ���㿪ʼɨ
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
        //�������������������λֵ
        int index = row*cols+col;
        if (row>=rows || col>=cols || row<0 || col<0 || str == null){
            return false;
        }else if (matrix[index] != str[len] || marked[index]){
            //�����ڴ�������ֵ���߱�־λΪtrue�������Ѿ�������
            return false;
        }
        if (len == str.length-1){
            //��������鵽�����˵���ҵ�
            return true;
        }
        //������λ����true
        marked[index] = true;
        //�ݹ���������
        if (hasPathTo(matrix,rows,cols,row,col-1,str,len+1,marked) || hasPathTo(matrix,rows,cols,row-1,col,str,len+1,marked) || hasPathTo(matrix,rows,cols,row,col+1,str,len+1,marked) || hasPathTo(matrix,rows,cols,row+1,col,str,len+1,marked)){
            return true;
        }
        //���û�ҵ���һ�����򷵻���һ�����ı��־λ������ѭ��
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
