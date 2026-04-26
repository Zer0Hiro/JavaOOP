package Interface;

/*
INTERFACE ALLOWS TO CREATE METHODS THAT DIFFERENT CLASSES CAN USE
Creates Erarchy to complete polymorphysm
Each class will @Override methods

EXAMPLE OF USE:

HelloInterface = h1 new Person();
. 
. 
. 
h1 = new World();

Different classes but same object
*/

public interface HelloInterface {
    void Hello();
    void Goodbye();
}
