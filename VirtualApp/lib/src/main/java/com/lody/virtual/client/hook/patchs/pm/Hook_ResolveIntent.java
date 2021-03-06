package com.lody.virtual.client.hook.patchs.pm;

import java.lang.reflect.Method;

import com.lody.virtual.client.hook.base.Hook;
import com.lody.virtual.client.local.VPackageManager;

import android.content.Intent;
import android.content.pm.ResolveInfo;

/**
 * @author Lody
 *
 *
 *         原型: resolveIntent(Intent intent, String resolvedType, int flags, int
 *         userId)
 */
/* package */ class Hook_ResolveIntent extends Hook {

	@Override
	public String getName() {
		return "resolveIntent";
	}

	@Override
	public Object onHook(Object who, Method method, Object... args) throws Throwable {
		Intent intent = (Intent) args[0];
		String resolvedType = (String) args[1];
		int flags = (int) args[2];
		ResolveInfo resolveInfo = VPackageManager.getInstance().resolveIntent(intent, resolvedType, flags);
		if (resolveInfo == null) {
			resolveInfo = (ResolveInfo) method.invoke(who, args);
		}
		return resolveInfo;
	}
}
