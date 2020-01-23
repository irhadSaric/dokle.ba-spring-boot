create PROCEDURE LAST_MESSAGE(
    receiver_in IN USERS.ID%TYPE,
    sender_in IN USERS.ID%TYPE,
    response OUT SYS_REFCURSOR
)
    IS
BEGIN
    OPEN response FOR
        SELECT * FROM MESSAGES M
        INNER JOIN USER_MESSAGES UM on M.ID = UM.MESSAGE_ID
        WHERE ((UM.RECEIVER_ID = receiver_in AND UM.SENDER_ID = sender_in) or
            (UM.RECEIVER_ID = sender_in AND UM.SENDER_ID = receiver_in))
        ORDER BY M.SENDING_TIME DESC
        FETCH NEXT 1 ROW ONLY;
    COMMIT;
END;
/

