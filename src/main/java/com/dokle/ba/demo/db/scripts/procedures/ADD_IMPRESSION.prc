create PROCEDURE ADD_IMPRESSION(
    receiver_id_in IN USER_IMPRESSIONS.RECEIVER_ID%TYPE,
    sender_id_in IN USER_IMPRESSIONS.SENDER_ID%TYPE,
    impression_in IN IMPRESSIONS.IMPRESSION%TYPE)
IS
    var_impression_id IMPRESSIONS.ID%TYPE;
BEGIN
    INSERT INTO IMPRESSIONS (IMPRESSION)
    VALUES (impression_in) RETURNING IMPRESSIONS.ID into var_impression_id;
    INSERT INTO USER_IMPRESSIONS (SENDER_ID, RECEIVER_ID, IMPRESSION_ID) VALUES (sender_id_in, receiver_id_in, var_impression_id);
    COMMIT;
END;
/

