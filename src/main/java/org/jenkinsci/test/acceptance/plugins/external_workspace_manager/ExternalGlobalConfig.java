package org.jenkinsci.test.acceptance.plugins.external_workspace_manager;

import org.jenkinsci.test.acceptance.po.PageAreaImpl;
import org.jenkinsci.test.acceptance.po.PageObject;

/**
 * Helper class for interacting with External Workspace Manager Plugin global config page.
 *
 * @author Alexandru Somai
 */
public class ExternalGlobalConfig extends PageAreaImpl {

    public ExternalGlobalConfig(PageObject context) {
        super(context, "/org-jenkinsci-plugins-ewm-steps-ExwsAllocateStep");
    }

    public void addDiskPool(String diskPoolId, String diskOneId, String diskTwoId) {
        // add disk pool
        control("repeatable-add").click();
        control("diskPools/diskPoolId").set(diskPoolId);

        // add first disk
        control("diskPools/repeatable-add").click();
        control("diskPools/disks/diskId").set(diskOneId);
        control("diskPools/disks/masterMountPoint").set("/fake-mount-point-1");

        // add second disk
        control("diskPools/repeatable-add").click();
        control("diskPools/disks[1]/diskId").set(diskTwoId);
        control("diskPools/disks[1]/masterMountPoint").set("/fake-mount-point-2");
    }
}
