## Explanation

This is one way around of a problem from Stackoverflow   
Details Problem: https://stackoverflow.com/questions/66009654/sorting-string-array-by-employee-id-number/66010738#66010738

Input File Format(Database.txt):
```
DADDY,1,GOOD,BAD
HELLO,0,GOOD,BAD
```

Solution Explanation: 

- Need to read data from a file line by line. 
  - BufferedReader handle this.
- Need to sort those line(String) based on *a inside numeric* value.
  - We can not sort an array of string based on its inside numeric value. So, we need to create a custom Object, here Data Class. 
  - We split a line by calling *parse* method. Parse method parse a string based on **,**. And after parsing, we construct Data object using our custom constructor and return it.
  - Then we store this **Data** object into an ArrayList(dataList). 
  - Finally we can call **Collection.sort(dataList)**. But is it sort data in correct order? Inside Data class there are 4 members, for sorting which member will be chosen?
    - Inside Data class, there we **@override** *compareTo* method. There we declare, we want to sort data based on *val* member. So, **Collection.sort(dataList)** sort data based on 
      desired numeric value.
- Need to write in .txt file again.
  - To do this easily, inside **Data** class, we **@override** toString method. So during file write, it creates our desired string without any hassle  
      
