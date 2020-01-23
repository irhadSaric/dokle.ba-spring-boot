create PROCEDURE GET_ALL_FOR_HOME_PAGE(
    response OUT SYS_REFCURSOR)
    IS
BEGIN
    OPEN response FOR
        SELECT P.*,
               C2.NAME AS "CountryName",
               P2.NAME AS "PaymentType",
               U.FIRST_NAME,
               U.ID AS "UserId",
               D.AVATAR
        FROM PATHS P
                 INNER JOIN COUNTRIES C2 on P.COUNTRY_ID = C2.ID
                 INNER JOIN PAYMENTS P2 on P.PAYMENT_ID = P2.ID
                 INNER JOIN USER_PATHS UP on P.ID = UP.PATH_ID
                 INNER JOIN USERS U on UP.USER_ID = U.ID
                 INNER JOIN USER_DETAILS ON U.ID = USER_DETAILS.USER_ID
                 INNER JOIN DETAILS D ON USER_DETAILS.DETAIL_ID = D.ID;
END;
/

