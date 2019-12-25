create function USER_EXISTS_ID(id_in IN USERS.ID%TYPE) return integer
    IS
    l_counter integer;
BEGIN
    SELECT count(*) INTO l_counter FROM USERS WHERE ID = id_in;
    return l_counter;

END;
/

