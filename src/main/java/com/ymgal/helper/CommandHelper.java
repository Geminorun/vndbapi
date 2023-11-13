package com.ymgal.helper;

import com.ymgal.Constants;
import com.ymgal.model.VndbFlags;
import com.ymgal.model.VndbFlagsConstant;

import java.util.stream.Collectors;

/**
 * @Auther: lyl
 * @Date: 2023/11/13 14:16
 * @Description:
 */
public class CommandHelper {
    public static String getFullCommand(String method, VndbFlags flags, VndbFlags invalidFlags) {
        Integer fullFlags;
        switch (method) {
            case Constants.GetVisualNovelCommand:
                fullFlags = VndbFlagsConstant.FullVisualNovel;
                break;
            case Constants.GetReleaseCommand:
                fullFlags = VndbFlagsConstant.FullRelease;
                break;
            case Constants.GetProducerCommand:
                fullFlags = VndbFlagsConstant.FullProducer;
                break;
            case Constants.GetCharacterCommand:
                fullFlags = VndbFlagsConstant.FullCharacter;
                break;
            case Constants.GetUserCommand:
                fullFlags = VndbFlagsConstant.FullUser;
                break;
            case Constants.GetVotelistCommand:
                fullFlags = VndbFlagsConstant.FullVotelist;
                break;
            case Constants.GetVisualNovelListCommand:
                fullFlags = VndbFlagsConstant.FullVisualNovelList;
                break;
            case Constants.GetWishlistCommand:
                fullFlags = VndbFlagsConstant.FullWishlist;
                break;
            case Constants.GetStaffCommand:
                fullFlags = VndbFlagsConstant.FullStaff;
                break;
            case Constants.GetUserListCommand:
                fullFlags = VndbFlagsConstant.FullUserList;
                break;
            case Constants.GetUserListLabelsCommand:
                fullFlags = VndbFlagsConstant.FullUserListLabels;
                break;
            default:
                fullFlags = 0;
                break;
        }
        String fullCommand = VndbFlags.getDescs(fullFlags).stream().map(x -> x.getDesc()).collect(Collectors.joining(","));
        return fullCommand;
    }

}
