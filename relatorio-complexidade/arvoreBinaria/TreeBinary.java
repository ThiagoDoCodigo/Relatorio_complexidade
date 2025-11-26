package arvoreBinaria;

public class TreeBinary{
   private SheetBinary root;
   
   public void insert(int valor){
      this.root = insertRecursive(valor, this.root);
   }
   
   public SheetBinary insertRecursive(int valor, SheetBinary cursor){
      //caso de parada
      if(cursor == null){
         return new SheetBinary(valor);  
      }
      
      if(valor < cursor.getValor()){
         cursor.setLeft(insertRecursive(valor, cursor.getLeft()));
      }else if(valor > cursor.getValor()){
         cursor.setRight(insertRecursive(valor, cursor.getRight()));
      }
      
      return cursor;
   }
   
   public int getHeigth(){
      return getHeigth(this.root);
   }
   
   public int getHeigth(SheetBinary sheet){
      if(sheet == null){
         return 0;
      }
      
      int leftHeight = getHeigth(sheet.getLeft());
      int rightHeight = getHeigth(sheet.getRight());
      
      return Math.max(leftHeight, rightHeight) + 1;
   }
   
   public int getSheets(){
      return getSheets(this.root);
   }
   
   public int getSheets(SheetBinary sheet){
      if(sheet == null){
         return 0;
      }
      
      int left = getSheets(sheet.getLeft());
      int right = getSheets(sheet.getRight());
      
      return (left + right) + 1;
   }
   
   public SheetBinary getSmall(){
      return getSmall(this.root);
   }
   
   public SheetBinary getSmall(SheetBinary sheet){
      if(sheet == null){
         return null;
      }
      
      if(sheet.getLeft() == null){
         return sheet;
      }
      
      return getSmall(sheet.getLeft());
   }
   
   public SheetBinary search(int valor){
      return searchRecursive(valor, this.root);
   }
   
   public SheetBinary searchRecursive(int valor, SheetBinary cursor){
      if(cursor == null){
         return null;
      }
      
      if(valor == cursor.getValor()){
         return cursor;
      }
      
      if(valor < cursor.getValor()){
         return searchRecursive(valor, cursor.getLeft());
      } else if(valor > cursor.getValor()){
         return searchRecursive(valor, cursor.getRight());
      }
      
      return null;
   }
}