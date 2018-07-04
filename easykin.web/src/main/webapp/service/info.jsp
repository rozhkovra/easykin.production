<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<table width="100%">
    <tr>
        <td>
            <div>
                <h1>Электричество</h1>
                <div>
                    <h2>(A - B) * Т = С</h2>
                    <ul>
                        <li>А - показания счетчика текущие</li>
                        <li>В - показания счетчика предыдущие</li>
                        <li>Т - тариф электроэнергия</li>
                        <li>С - сумма платежа</li>
                    </ul>
                </div>
            </div>
            <div>
                <h1>Газ</h1>
                <div>
                    <h2>N * Т = С</h2>
                    <ul>
                        <li>N - проживающих по прописке</li>
                        <li>Т - тариф газ</li>
                        <li>С - сумма платежа</li>
                    </ul>
                </div>
            </div>
        </td>
        <td>
            <div>
                <h1>Водоканал</h1>
                <div>
                    <h2>(Ax1 - Bx1) * (Т1 + Т2) + (Aг1 - Вг1) * Т1 = С</h2>
                    <ul>
                        <li>Ax1 - показания счетчика холодной воды текущие</li>
                        <li>Bx1 - показания счетчика холодной воды предыдущие</li>
                        <li>Aг1 - показания счетчика горячей воды текущие</li>
                        <li>Вг1 - показания счетчика горячей воды предыдущие</li>
                        <li>Т1 - тариф водоотведение</li>
                        <li>Т2 - тариф водопотребление</li>
                        <li>С - сумма платежа</li>
                    </ul>
                </div>
            </div>
            <div>
                <h1>ГВС</h1>
                <div>
                    <h2>(Aг1 - Bг1) * Т = С</h2>
                    <ul>
                        <li>Aг1 - показания счетчика горячей воды текущие</li>
                        <li>Вг1 - показания счетчика горячей воды предыдущие</li>
                        <li>Т - тариф ГВС</li>
                        <li>С - сумма платежа</li>
                    </ul>
                </div>
            </div>
        </td>
    </tr>
</table>