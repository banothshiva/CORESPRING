<%@ page contentType="text/html;charset=UTF-8" language="java" prifix="c" %>
<center>
    <h1 style="color: red">SDFC BANK</h1>
    <h1 style="color:green">EXTRA ORDINARY SERVICES</h1>
    <h1 style="color: red">VIEW ACCOUNT DETAILS</h1>
    <c:if test="${not empty details}">
        <h3 style="color: chocolate;">WELCOME TO DERA USER  ${name}</h3>
        <table border="1">
            <tr>
                <th>ACCOUNT NUMBER </th>
                <th>USER NAME</th>
                <th>AMOUNT  </th>
                <th>ADDRESS </th>
                <th>MOBILE NUMBER</th>
            </tr>
            <tr>
                <td>${details.accountNumber}</td>
                <td>${details.name}</td>
                <td>${details.amount}</td>
                <td>${details.address}</td>
                <td>${details.mobileNumber}</td>
            </tr>
        </table>
    </c:if>
    <p></p>
    <p></p>
    <a href="/">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/addAccount">NEW ACCOUNT</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/checkBalance">BALANCE</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/depositAmount">DEPOSIT</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/withdrawBalance">WITHDRAW</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/transferBalance">TRANSFER</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/close">CLOSE</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/about">ABOUT</a>&nbsp;&nbsp;&nbsp;&nbsp;
</center>