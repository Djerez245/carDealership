# JDBC for car dealership 

## classes
 I made 3 separate  sets of DAO classes  for my project one for my
 vehicles one for dealership and one for my admin i have the interfaces and 
 the implementation methods for them.

![classes](/images/dealer%20classes.png)
![interfaceExample](/images/v%20inter%20.png)

## structure
For each method in the dealership and the vehicles class I used a similar
structure as you can see in the image below

![structure](/images/method_structure.png)

Here I initialized an array list and then define the variables. Then I made a connection in a try with resources 
then I made a prepared statement for my query and then put my results from my query into
a result set. Then I used a while loop to convert my results into objects and added the objects into my 
array list and then at the end of my method I return the array list.

My find by method are the same but except in my prepared statement I use a question
mark as a place hold for the users input then I use rs.set(dataType)("column name")

![findby](/images/findbyMethod.png)

My method to add vehicles is a little different because I don't use a result set since I am only returning one 
vehicle.

![addVMethod](/images/addV.png)

So here I use statement.set(dataType) to set all the values and as you can see I don't need
a while loop since there will only be one vehicle that will be returned. I also use executeUpdate instead
of executeQuery since I am updating the table. I also print out the rows update so the admin can have
a visual conformation of the amount of rows updated was only one.

## User Interface
In my user interface class I already had a method to print out an array list, so I 
just replaced the method I had in there already and I entered my new method I just created 
and add the users input into the parameters.

![ui](/images/uiUpdate.png)
