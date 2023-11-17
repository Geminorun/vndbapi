package com.ymgal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ymgal.Interfaces.IRequestOptions;
import com.ymgal.filter.VndbFilters;
import com.ymgal.helper.JsonHelper;
import com.ymgal.helper.TcpHelper;
import com.ymgal.model.VisualNovel.VisualNovel;
import com.ymgal.model.VndbFlags;
import com.ymgal.model.VndbResponse;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

/**
 * @Auther: lyl
 * @Date: 2023/10/23 20:39
 * @Description:
 */
public class SocketTest {

    public static <T> T SendGetRequestInternalAsync(String cmd, TypeReference<T> typeReference) {
        TcpHelper.sendData(cmd);
        String response = TcpHelper.getResponse();

        String[] results = response.split(" ", 2);

        if (results.length == 2 &&
                (results[0].equals(Constants.Results) || results[0].equals(Constants.DbStats)))
            return JsonHelper.parse(results[1], typeReference);
        return null;
    }

    public static VndbResponse<VisualNovel> GetVisualNovelAsync(String filters, VndbFlags flags, IRequestOptions options) {
        String method = Constants.GetVisualNovelCommand;
        System.out.println(method);
        // Need a way to communicate to the end user that these null values are not from the API?
        Integer vndbFlag = VndbUtils.getVndbFlag(method, flags);
        String fields = VndbFlags.getDescs(vndbFlag).stream().collect(Collectors.joining(",", " ", " "));
        String cmd = method + fields + "(" + filters + ")";

        TypeReference<VndbResponse<VisualNovel>> responseType = new TypeReference<VndbResponse<VisualNovel>>() {
        };
        return SendGetRequestInternalAsync(cmd, responseType);
    }

    @Test
    public void tcpTest() {
        TcpHelper.Login();
        String filters = VndbFilters.Id.Equals(18).toString();
        VndbResponse<VisualNovel> visualNovelVndbResponse = GetVisualNovelAsync(filters, VndbFlags.Basic, null);
        //TcpHelper.Loginout();
    }

}
