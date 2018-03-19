/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.edd1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo Borjas
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File f = new File("C:\\Users\\Leonardo Borjas\\Documents\\lab2.txt");
        char[][] laberinto = null;
        int x = 0;
        int y = 0;
        try {
            Scanner texto = new Scanner(f);
            while (texto.hasNext()) {
                y++;
                x = texto.nextLine().length();
            }
            texto.close();
            laberinto = new char[y][x];
            Scanner texto2 = new Scanner(f);
            for (int i = 0; i < y; i++) {
                String linea = texto2.next();
                for (int j = 0; j < x; j++) {
                    laberinto[i][j] = linea.charAt(j);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }

        int[] coordenadas = entrada(laberinto);
        laberinto[coordenadas[0]][coordenadas[1]] = '+';
        LinkedStack backtracking = salida(laberinto, coordenadas[0], coordenadas[1]);
        while (!backtracking.isEmpty()) {
            Laberinto maze = (Laberinto)backtracking.pop();
            laberinto[maze.getX()][maze.getY()]='@';
        }
        printMatriz(laberinto);

    }

    public static int[] entrada(char[][] matriz) {
        int[] coordenadas = new int[2];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == 0) {
                    if (matriz[i][j] == '0') {
                        coordenadas[0] = i;
                        coordenadas[1] = j;
                        return coordenadas;
                    }

                } else if (i > 0 && i < matriz.length) {
                    if (matriz[i][j] == '0') {
                        coordenadas[0] = i;
                        coordenadas[1] = j;
                        return coordenadas;
                    }

                } else if (i == matriz.length) {
                    if (matriz[i][j] == '0') {
                        coordenadas[0] = i;
                        coordenadas[1] = j;
                        return coordenadas;
                    }

                }
            }
        }
        return coordenadas;
    }

    public static void printMatriz(char[][] laberinto) {
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[1].length; j++) {
                System.out.print("[" + laberinto[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println("");
    }

    public static LinkedStack salida(char[][] laberinto, int x, int y) {
        int size1 = laberinto.length;
        int size2 = laberinto[0].length;
        boolean salio = false;
        int cont = 0;
        LinkedStack stack = new LinkedStack();
        stack.push(new Laberinto(x, y));
        while (!salio) {
            cont = 0;
            printMatriz(laberinto);
            //ARRIBA
            if (x > 0 && cont == 0) {
                if (laberinto[((Laberinto) stack.top()).getX() - 1][((Laberinto) stack.top()).getY()] == '0' && !salio) {
                    x--;
                    laberinto[x][y] = '+';
                    stack.push(new Laberinto(x, y));
                    cont++;
                }
            }

            //DERECHA
            if (y + 1 < size2 && cont == 0) {
                if (laberinto[((Laberinto) stack.top()).getX()][((Laberinto) stack.top()).getY() + 1] == '0' && !salio) {
                    y++;
                    laberinto[x][y] = '+';
                    stack.push(new Laberinto(x, y));
                    cont++;
                }
            }

            //ABAJO
            if (x + 1 < size1 && cont == 0) {
                if (laberinto[((Laberinto) stack.top()).getX() + 1][((Laberinto) stack.top()).getY()] == '0' && !salio) {
                    x++;
                    laberinto[x][y] = '+';
                    stack.push(new Laberinto(x, y));
                    cont++;
                }
            }

            //IZQUIERDA
            if (y > 0 && cont == 0) {
                if (laberinto[((Laberinto) stack.top()).getX()][((Laberinto) stack.top()).getY() - 1] == '0' && !salio) {
                    y--;
                    laberinto[x][y] = '+';
                    stack.push(new Laberinto(x, y));
                    cont++;
                }
            }

            if (cont == 0) {
                laberinto[x][y] = '+';
                stack.pop();
                Laberinto back = (Laberinto)stack.top();
                x=back.getX();
                y=back.getY();
            }
            
            if (x==size1-1 || x==0 || y==size2-1 || y==0) {
                salio=true;
            }
        }
        return stack;
    }
}

/*



int main() {
  int x;
  cout<< "Ingrese un numero para sacar su factorial" <<endl;
  cin >> x;
  int numero = factorial(x);
  cout << numero <<endl;
  return 0;
}*/

 /*
}
int factorial(int n){
  int x = 1;
  Stack* stack = new ArrayStack();
  while (n>0) {
    stack->push(new Integer (n));
    n--;
  }
  while (!stack->isEmpty()) {
    x*= dynamic_cast<Integer*>(stack->pop())->getInt();
  }
  return x;
}

 */
