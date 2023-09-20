### Some points, that were not defined clearly:

 - **"Aged Brie" behaviour after sellIn date.**
   It was not specified whether the quality of this item should increase by one or two after sellIn date. The quality of this product always increases by 1 in this implementation

 - **Item names.** It was not specified whether the items could have names different from test example (for example, could we add backstage passes to a concert other than the 'TAFKAL80ETC' one). The 'startsWith()' function is used in this implementation to make this possible.

 - **Data Validation.** The assignment did not specify whether the input data could be invalid. This implementation assumes that the data is always valid.

 - **Backstage Passes** In this implementation, the ticket quality increases on the 10th and 5th day inclusive.
