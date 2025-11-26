package arvoreBinaria;

public class SheetBinary{
   private int valor;
   private SheetBinary left;
   private SheetBinary right;
   
   
   public SheetBinary(int valor){
      this.valor = valor;
      this.left = null;
      this.right = null;
   }
   
   public int getValor(){
      return this.valor;
   }
   
   public void setValor(int valor){
      this.valor = valor;
   }
   
   public SheetBinary getLeft(){
      return this.left;
   }
   
   public void setLeft(SheetBinary left){
      this.left = left;
   }
   
   public SheetBinary getRight(){
      return this.right;
   }
   
   public void setRight(SheetBinary right){
      this.right = right;
   }
   
   @Override
   public String toString(){
      return "Valor " +  this.valor;
   }   
}