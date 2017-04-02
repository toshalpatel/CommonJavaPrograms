 import java.awt.* ;
 import java.awt.event.* ; 
 import java.applet.* ; 
 
 public class EightQueen extends Applet implements ActionListener { 
     List solutionList ; 
     String msg="SOLUTIONS TO THE EIGHT QUEENS PROBLEM "; 
     String msg2="Click on a number in the List Box."; 
     String msg3="Then click 'View' to see the corresponding positions of Queens on the ChessBoard."; 
     String msg4="Or simply Double Click on a number to see the corresponding positions of Queens."; 
     String msg5="The Corresponding Positions of Queens are indicated by RED squares on the Board ."; 
     Label lbl1=new Label(msg); 
     Label lbl2=new Label(msg2); 
     Label lbl3=new Label(msg3); 
     Label lbl4=new Label(msg4); 
     Label lbl5=new Label(msg5); 
     Button b1=new Button("View");
     int equiv[]=new int[8]; 
     int solution[] = new int[8] ; 
     int currentRow ; int flag=1; 
     
     public void init() {
         setLayout(new FlowLayout(FlowLayout.LEFT)); 
         currentRow = 0 ; 
         solutionList=new List(8,false) ; 
         setBackground(Color.black); 
         setForeground(Color.orange); 
         add(lbl1); 
         add(lbl2); 
         add(lbl3); 
         add(lbl4); 
         msg=""; 
         add(solutionList); 
         add(b1); 
         solutionList.addActionListener(this); 
         b1.addActionListener(this); add(lbl5); 
     } 
     
     public void actionPerformed(ActionEvent e) { 
         String msg2=solutionList.getSelectedItem(); 
         int equivalent=Integer.parseInt(msg2); 
         for(int ctrn=0;ctrn<=7;ctrn++) { 
             equiv[ctrn]=equivalent%10 ; 
             equivalent=equivalent/10; 
         }; 
         repaint(); 
     }
     
     public void paint(Graphics g) { 
         int ctr1,ctr2,row,col ; 
         for(ctr1=0;ctr1<=63;ctr1++) {
             row=(int)(ctr1%8) ; 
             col =(int)(ctr1 / 8 ); 
             if((row+col)%2==0) { 
                 g.setColor(Color.gray); 
                 g.fillRect(310+10*row,118+10*col,10,10); 
             } 
             else if ((row+col)%2==1) { 
                 g.setColor(Color.white); 
                 g.fillRect(310+10*row,118+10*col,10,10); 
             }; 
         } 
         if(equiv[0]!=0) 
             for(ctr1=0;ctr1<=7;ctr1++) { 
                 row=ctr1; 
                 col = equiv[7-ctr1]-1; 
                 g.setColor(Color.red); 
                 g.fillRect(310+10*row,118+10*col,10,10); 
             }; 
     } 
     public void start() { 
         for(int ctr1=0;ctr1<=7;ctr1++) 
             placeQueens(0,ctr1); 
     } 
     
     public void placeQueens(int row,int col) {
         solution[row]=col ; 
         int ctr1,ctr2; 
         if(row==7) 
         { 
             displayQueens() ; 
             return ; 
         }; 
         int flagX = 1 ; 
         for(ctr2=0;ctr2<=7;ctr2++) 
         { 
             flagX=1 ; 
             for(ctr1=0;ctr1<=row;ctr1++) 
                 if(solution[ctr1] == ctr2 || (solution[ctr1]-ctr2)*(solution[ctr1]-ctr2)== (row+1-ctr1)*(row+1-ctr1) ) 
                     flagX=0; 
             if(flagX==1) placeQueens(row+1,ctr2); 
         }; 
     } 
     public void displayQueens() { 
         msg=""; 
         int ctr1; 
         for(ctr1=0;ctr1<=7;ctr1++) 
             msg+=(solution[ctr1]+1); 
         solutionList.add(msg); 
     } 
 }
