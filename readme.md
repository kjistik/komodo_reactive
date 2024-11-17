The idea of the class structure is that it works as follows:
  
### Item: 

Is a product that is sold, **regardless of its specifications and brand**. We can say that we sell a certain brand detergent. The varieties are the different presentations of the detergent in question. Similar to the option to choose different models of free market (see any mobile phone or notebook that allows you to choose storage size, ram or colour).

### price_history:

Packs all the prices of the varieties. I can think of a menu that, choosing an item, allows the creation of a price and the generation of all the varieties that will use it. I reject the use of an intermediate table because the **prices store information about the time period in which they apply**, and different prices may apply for different varieties.

### Variety:

Following the example of Mercado Libre, we can make the varieties generic titles, such as medium, large, small for packages of different presentations of the same product. Remember that this is aimed at physical commercial shops in different areas.

### Price: 

It is only a real value along with a date. It is important to note that this price **will be applied once per occurrence of the unit** as specified in the variety class. This value is a real, so if a unit were dependent on measurements (such as food), it could be applied in the same way.

The present iteration of the program is aimed at **inventory management only**, but there is speculation about the possibility of adding control over sales and restocking if the product is successful.