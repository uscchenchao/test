import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;


public class MainAct {
	//http://www.mitbbs.com/article_t/JobHunting/32622081.html
/*第一轮
给一个矩阵，每个格子上有三种可能，空房，阻碍物或者是保安，阻碍物不能进，空房
四个方向都能进，要写代码给每个空房标记其离最近的保安的距离，比如

000
BGG
B00

B表示障碍物，G表示保安，0表示空房，应该标记为

211
BGG
B11*/
	//Solution: store all G first in a queue then do the BFS together
	public void solveMatwithGuard(char[][] mat){
		Queue<Point> guard_queue = new LinkedList<Point>();
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j < mat[0].length; j++){
				if(mat[i][j] == 'G'){
					guard_queue.add(new Point(i + 1, j));
					guard_queue.add(new Point(i - 1, j));
					guard_queue.add(new Point(i, j + 1));
					guard_queue.add(new Point(i, j - 1));

				}
			}
		}
		int curlayer = 1;
		while(!guard_queue.isEmpty()){
			int cur_size = guard_queue.size();
			for(int i = 0; i < cur_size; i++){
				Point p = guard_queue.poll();
				if(p.x < 0 || p.x >= mat.length || p.y < 0 || p.y >= mat[0].length || mat[p.x][p.y] != '0')
					continue;
				mat[p.x][p.y] += curlayer;
				guard_queue.add(new Point(p.x + 1, p.y));
				guard_queue.add(new Point(p.x - 1, p.y));
				guard_queue.add(new Point(p.x, p.y + 1));
				guard_queue.add(new Point(p.x, p.y - 1));
			}
			curlayer++;
		}
		printMat(mat);
	}
	
	public void printMat(char[][] mat){
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j < mat[0].length; j++){
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}				
	}
	//http://www.mitbbs.com/article_t/JobHunting/32881701.html
	//给一个string of nested ternary operations例如a?b?c:d:e，build a tree：root是
	//a，左子树是b?c:d对应的tree ，右子树是e。保证input都是valid的。
	class BTNode{
		BTNode left,right;
		Character val;
		public BTNode(Character val){
			this.val = val;
		}
		public BTNode(){
			this(null);
		}
	}
	
	public BTNode TOper_to_Tree(String input){
		
	}
	
	public static void main(String[] args){
		MainAct m = new MainAct();
		char[][] mat = {"000".toCharArray(), "BGG".toCharArray(), "B00".toCharArray()};
		m.solveMatwithGuard(mat);
	}
}
