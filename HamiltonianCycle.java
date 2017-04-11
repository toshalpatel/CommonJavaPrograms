import java.util.Arrays;

public class HamiltonianCycle {
int n = 8;
int x[] = {0, 0, 0, 0, 0, 0, 0, 0};

int g[][] = {{0, 1, 1, 0, 0, 0, 1, 0},
{1, 0, 1, 0, 0, 0, 0, 1},
{1, 1, 0, 1, 0, 1, 0, 0},
{0, 0, 1, 0, 1, 0, 0, 0},
{0, 0, 0, 1, 0, 1, 0, 0},
{0, 0, 1, 0, 1, 0, 1, 0},
{1, 0, 0, 0, 0, 1, 0, 1},
{0, 1, 0, 0, 0, 0, 1, 0}};

public void nextValue(int k) {
int j;

  do {
    x[k] = (x[k] + 1) % (n);
    if(x[k] == 0) return;
      if((g[x[k-1]][x[k]] != 0)) {
        for(j = 0; j &lt; k; j++) {
          if(x[j] == x[k])
          break;
        }
        if(j == k) {
          if(k &lt; (n-1))
            return;
          if((k == (n-1)) &amp;&amp; (g[x[0]][x[k]] != 0))
            return;
          }
        }
  }while(true);
}
public void hCycle(int k) {
  do {
      nextValue(k);
      if(x[k] == 0)
        return;
      if(k == (n - 1)) {
        System.out.println(&quot;Hamiltonian Cycle - &quot; + Arrays.toString(x));
        break;
      }
      else
        hCycle(k+1);
  }while(true);
}

  public static void main(String[] args) {
      int i, j;
      HamiltonianCycle hc = new HamiltonianCycle();
      for(i = 0; i &lt; hc.n; i++) {
      for(j = 0; j &lt; hc.n; j++)
      System.out.print(hc.g[i][j] + &quot;\t&quot;);
      System.out.println();
  }
  hc.hCycle(1);
}
}
