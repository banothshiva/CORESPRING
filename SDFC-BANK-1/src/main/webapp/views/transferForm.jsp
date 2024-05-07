<center>
    <h1 style="color: red">SDFC BANK</h1>
    <h2 style="color:orange">EXTRA ORDINARY SERVICES</h2>
    <h3 style="color:green;">TRANSFER FORM PAGE </h3>
    <table border="1">
        <form action="/transferFunds" method="post">
            <tr>
                <td>ACCOUNT NUMBER :</td>
                <td><input type="number" name="accountNumber"></td>
            </tr>
            <tr>
                <td> NAME :</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>PASSWORD :</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>TARGET ACCOUNT NUMBER :</td>
                <td><input type="targetAccountNumber" name="targetAccountNumber"></td>
            </tr>
            <tr>
                <td>AMOUNT :</td>
                <td><input type="text" name="amount"></td>
            </tr>
            <tr>
                <td></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"></td>
                <td><input type="reset" value="Clear"></td>
            </tr>
        </form>
    </table>
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