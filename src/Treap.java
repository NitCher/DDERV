import java.util.Scanner;
 
 /* Class CTNode */
 class CTNode
 {    
     CTNode left, right;
     int value;
 
     /* Constructor */
     public CTNode()
     {
         left = null;
         right = null;
         value = 0;         
     }     
 }
 
 /* Class CartesianTree */
 class CartesianTree
 {
     private CTNode root;
 
     /* Constructor */
     public CartesianTree(int[] data)
     {
         root = build(data);
     }
     /* Function to build Cartesian Tree from array */
     public CTNode build(int[] data) 
     {
        if (data == null || data.length == 0) 
            return null;
        return build(data, 0, data.length - 1);
     }
     /* Function to build Cartesian Tree from array */
     private CTNode build(int[] data, int start, int end) 
     {
         if (end < start) 
             return null;
         int min = Integer.MAX_VALUE;
         int minIndex = -1;        
         for (int i = start; i <= end; i++) 
         {
             if (data[i] < min) 
             {
                 min = data[i];
                 minIndex = i;
             }
         }        
         CTNode node = new CTNode();
         node.value = min;        
         node.left = build(data, start, minIndex - 1);
         node.right = build(data, minIndex + 1, end);        
         return node;
     }      
     /* Function to check if tree is empty */
     public boolean isEmpty()
     {
         return root == null;
     }
     /* Functions to count number of nodes */
     public int countNodes()
     {
         return countNodes(root);
     }
     private int countNodes(CTNode r)
     {
         if (r == null)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.left);
             l += countNodes(r.right);
             return l;
         }
     }
     /* Function for inorder traversal */
     public void inorder()
     {
         inorder(root);
     }
     private void inorder(CTNode r)
     {
         if (r != null)
         {
             inorder(r.left);
             System.out.print(r.value +" ");
             inorder(r.right);
         }
     }
     /* Function for preorder traversal */
     public void preorder()
     {
         preorder(root);
     }
     private void preorder(CTNode r)
     {
         if (r != null)
         {
             System.out.print(r.value +" ");
             preorder(r.left);             
             preorder(r.right);
         }
     }
     /* Function for postorder traversal */
     public void postorder()
     {
         postorder(root);
     }
     private void postorder(CTNode r)
     {
         if (r != null)
         {
             postorder(r.left);             
             postorder(r.right);
             System.out.print(r.value +" ");
         }
     }         
 }
 
 /* Class CartesianTreeTest */
 public class Treap
 {
     public static void main(String[] args)
     {            
        Scanner scan = new Scanner(System.in);
        System.out.println("Тест декартовых деревьев\n");
        System.out.println("Введите количество целочисленных значений");
        int N = scan.nextInt();
        int arr[] = new int[N];
        System.out.println("\nВведите \"+ N +\" целочисленные значения");
        for (int i = 0; i < N; i++)
            arr[i] = scan.nextInt();
        /* Make cartesian tree from given array */         
        CartesianTree ct = new CartesianTree(arr);
        /* Print tree details */
        System.out.println("\nДетали дерева :");
        System.out.println("Пустой статус - "+ ct.isEmpty());
        System.out.println("Нет узлов - "+ ct.countNodes());
        System.out.print("Разместить : ");
        ct.postorder();
        System.out.print("\nПредварительный : ");
        ct.preorder();
        System.out.print("\nЦель : ");
        ct.inorder();
        System.out.println();
     }
 }


