public class Person
{
  private int alter;
  private String name;
  
  public Person (int alter, String name)
  {
    this.name = name;
    this.alter = alter;
  }
  
  public int getAlter()
  {                
   return this.alter;
  }
    
  public void setAlter(int alter)
  {
   this.alter = alter;
  }
   
  public String getName()
  {
   return this.name;
  }
    
  public void setName(String name)
  {
   this.name = name;
  }  
}
