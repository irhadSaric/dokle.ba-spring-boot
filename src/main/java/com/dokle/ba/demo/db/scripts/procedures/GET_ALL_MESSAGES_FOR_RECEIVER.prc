create PROCEDURE GET_ALL_MESSAGES_FOR_RECEIVER(
    receiver_id_in IN USERS.ID%TYPE,
    sender_id_in IN USERS.ID%TYPE,
    response OUT SYS_REFCURSOR)
    IS
BEGIN
    OPEN response FOR
        SELECT * FROM MESSAGES
                          INNER JOIN USER_MESSAGES UM ON MESSAGES.ID = UM.MESSAGE_ID
        WHERE (UM.RECEIVER_ID = receiver_id_in AND UM.SENDER_ID = sender_id_in)
           OR (UM.SENDER_ID = receiver_id_in AND UM.RECEIVER_ID = sender_id_in)
        ORDER BY MESSAGES.SENDING_TIME;
    COMMIT;
END;
/

