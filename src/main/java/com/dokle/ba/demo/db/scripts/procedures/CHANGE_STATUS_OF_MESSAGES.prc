create PROCEDURE CHANGE_STATUS_OF_MESSAGES(
    receiver_in IN USERS.ID%TYPE,
    sender_in IN USERS.ID%TYPE)
IS
CURSOR C IS
    SELECT *
    FROM MESSAGES M
    INNER JOIN USER_MESSAGES UM ON M.ID = UM.MESSAGE_ID
    WHERE UM.SENDER_ID = sender_in AND UM.RECEIVER_ID = receiver_in;
BEGIN
    FOR TEMP IN C LOOP
        UPDATE MESSAGES SET STATUS_ID = 21 WHERE ID = TEMP.ID;
        end loop;
END;
/
