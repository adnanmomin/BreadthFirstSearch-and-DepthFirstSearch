import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bfs {
	
	static BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
	static int[][] graph = new int[50][50];
	static int nodes, i, j, k, front = 0, rear = 0, v = 0;
	static char[] queue = new char[50];
	static char[] visited = new char[50];
	static char[] temp = new char[1];

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
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
		System.out.print("BFS Traversal is: ");
		for(i = 1; i <= nodes; i++) {
			System.out.print(visited[i]);
			if(i != nodes)
				System.out.print("->");
		}
		System.out.print("\n\n#########################");
		System.out.print("\n#  Code by Adnan Momin  #");
		System.out.print("\n#########################");

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
					if(inqueue(temp[0])){
						continue;
					} else {
						enqueue(temp[0]);
					}
				}
			}
			if(queue[front] == (char)(0)) {
				break;
			}
			v++;
			visited[v] = queue[front];
			for(k = 0; k < rear - 1; k++) {
				queue[k] = queue[k + 1];
			}
			rear--;
			queue[rear] = (char)(0);
			i = (int)(visited[v]) - 64 - 1;
		}		
	}

	private static boolean inqueue(char temp) {
		for(k = 0; k < rear; k++) {
			if(queue[k] == temp) {
				return true;
			}
		}
		return false;
	}

	private static void enqueue(char c) {
		queue[rear] = c;
		rear++;
	}

	private static void initialize() {
		for(i = 1; i <= nodes; i++) {
			visited[i] = (char)(0);
			queue[i] = (char)(0);
		}		
	}
}
