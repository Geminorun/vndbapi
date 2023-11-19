package com.ymgal;

import com.ymgal.filter.VndbFilters;
import com.ymgal.helper.TcpHelper;
import com.ymgal.model.User.User;
import com.ymgal.model.VndbResponse;
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

        //VndbResponse<VisualNovel> visualNovelVndbResponse = VndbGetMethod.GetVisualNovel(VndbFilters.Id.Equals(18).toString());
        //VndbResponse<Release> visualNovelVndbResponse = VndbGetMethod.GetReleaseAsync(VndbFilters.VisualNovel.Equals(18).toString());

        //VndbResponse<Producer> visualNovelVndbResponse = VndbGetMethod.GetProducerAsync(VndbFilters.Id.Equals(9).toString());

        //VndbResponse<Character> visualNovelVndbResponse = VndbGetMethod.GetCharacterAsync(VndbFilters.VisualNovel.Equals(17).toString());
        VndbResponse<User> visualNovelVndbResponse = VndbGetMethod.GetUserAsync(VndbFilters.Id.Equals(2).toString());


        TcpHelper.Loginout();
    }
}
