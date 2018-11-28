# springbootOneToOne

Bi-directional OneToOne mapping between Person and vehicle entity objects.
Cascading included : Save or delete on a Person object automatically saves and deletes the Vehicle object. *Caution : Special care has to be taken while deleting a vehicle object (child object) only. You need to break (nullify) the association between the person and the vehicle to be deleted. So set null for the person's vehicle field to break the association. Then the cascading feature of Person won't affect the deletion of the vehicle otherwise error.
