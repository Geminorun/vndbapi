package com.ymgal;

import com.ymgal.helper.TcpHelper;
import org.junit.jupiter.api.Test;

/**
 * @Auther: lyl
 * @Date: 2023/10/23 20:39
 * @Description:
 */
public class SocketTest {

    @Test
    public void tcpTest() {
        TcpHelper.Login();
        TcpHelper.SetInputStream("get vn basic,anime (id = 17)");
        TcpHelper.Loginout();
    }
}
