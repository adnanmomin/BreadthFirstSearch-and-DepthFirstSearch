import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dfs {

	/**
	 * @param args
	 */
	
	static BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
	static int[][] graph = new int[50][50];
	static int nodes, i, j, v = 0, s = 1, k, l, top = 1;
	static char[] visited = new char[50];
	static char[] stack = new char[50];
	static char[] temp = new char[1];
	static int[] havechild = new int[50];
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Enter No. of Nodes: ");
		nodes = Integer.parseInt(b.readLine());
		
		for(i = 1; i <= nodes; i++) {
			for(j = 1; j <= nodes; j++) {
				if(i == j) {
					graph[i][j] = 0;
					continue;
				}
				if(graph[j][i] == 1)
					continue;
				System.out.println("Enter 1 if state '" +(char)(64 + i)+ "' " +
						"has an Edge with '" +(char)(64 + j)+ "' else Enter 0: ");
				graph[i][j] = Integer.parseInt(b.readLine());
				if(graph[i][j] == 1) {
					havechild[i]++;
				}
				//graph[j][i] = graph[i][j];
				graph[j][i] = 0;
			}
		}
		System.out.println("\nEdge Matrix is:\n");
		for(i = 0; i <= nodes; i++) {
			for(j = 0; j <= nodes; j++) {
				if(i == 0){
					if(j == nodes)
						continue;
					System.out.print("\t"+(char)(65 + j));
				} else {
					if(j == 0)
						System.out.print((char)(64 + i)+ "\t");
					else
						System.out.print("" +graph[i][j]+ "\t");
				}
			}
			System.out.println();
		}

		System.out.println();
		initialize();
		traverse(nodes);
		System.out.print("DFS Traversal is: ");
		for(i = 1; i <= nodes; i++) {
			System.out.print(visited[i]);
			if(i != nodes)
				System.out.print("->");
		}
		System.out.print("\n\n#########################");
		System.out.print("\n#  Code by Adnan Momin  #");
		System.out.print("\n#########################");
	}

	private static void initialize() {
		for(i = 1; i <= nodes; i++) {
			visited[i] = (char)(0);
			stack[i] = (char)(0);
			havechild[i] = 0;
		}		
	}

	private static void traverse(int nodes) {
		i = 1; j = 1;
		for(i = 1; i <= nodes; i++) {
			for(j = 1; j <= nodes; j++) {
				if(i == 1 && j == 1) {
					v++;
					visited[v] = (char)(64 + j);
				}
				if(graph[i][j] == 1) {
					temp[0] = (char)(64 + j);
					if(isvisited(temp[0])) {
						continue;
					}
					if(instack(temp[0])) {
						stack[top] = temp[0];
						top++;
					}
				}
			}
			v++;
			visited[v] = stack[top - 1];
			stack[top - 1] = (char)(0);
			top--;
			i = (int)(temp[0]) - 64 - 1;
			if(havechild[i + 1] == 0) {
				i = (int)(visited[v]) - 64 - 1;
			}
			if (v == nodes) {
				break;
			}
		}
	}

	private static boolean instack(char temp) {
		for(l = 1; l <= nodes; l++){
			if(stack[l] == temp) {
				return true;
			}
		}
		return true;
	}

	private static boolean isvisited(char temp) {
		for(k = 1; k <= nodes; k++){
			if(visited[k] == temp) {
				return true;
			}
		}
		return false;
	}

}
