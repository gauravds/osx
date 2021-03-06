/* This file contains the exception-handling save_world and restore_world 
   routines, which need to do a run-time check to see if they should save
   and restore the vector regs.  */

.data
	.align 2

#ifdef __DYNAMIC__

.non_lazy_symbol_pointer
L_has_vec$non_lazy_ptr:
	.indirect_symbol __cpu_has_altivec
	.long	0

#else

/* For static, "pretend" we have a non-lazy-pointer.  */

L_has_vec$non_lazy_ptr:
	.long __cpu_has_altivec

#endif


.text
	.align 2

/* save_world and rest_world save/restore F14-F31 and possibly V20-V31
   (assuming you have a CPU with vector registers; we use a global var
   provided by the System Framework to determine this.)

   SAVE_WORLD takes R0 (the caller`s caller`s return address) and R11 (the
   stack frame size) as parameters.  It returns VRsave in R0 if we`re on
   a CPU with vector regs.  */

.private_extern save_world
save_world:
	stw r0,8(r1)
	mflr r0
	bcl 20,31,Ls$pb
Ls$pb:	mflr r12
	addis r12,r12,ha16(L_has_vec$non_lazy_ptr-Ls$pb)
	lwz r12,lo16(L_has_vec$non_lazy_ptr-Ls$pb)(r12)
	mtlr r0
	lwz r12,0(r12)
				/* grab CR  */
	mfcr r0	
				/* test HAS_VEC  */
	cmpwi r12,0
	stfd f14,-144(r1)
	stfd f15,-136(r1)
	stfd f16,-128(r1)
	stfd f17,-120(r1)
	stfd f18,-112(r1)
	stfd f19,-104(r1)
	stfd f20,-96(r1)
	stfd f21,-88(r1)
	stfd f22,-80(r1)
	stfd f23,-72(r1)
	stfd f24,-64(r1)
	stfd f25,-56(r1)
	stfd f26,-48(r1)
	stfd f27,-40(r1)
	stfd f28,-32(r1)
	stfd f29,-24(r1)
	stfd f30,-16(r1)
	stfd f31,-8(r1)
	stmw r13,-220(r1)
				/* stash CR  */
	stw r0,4(r1)
				/* set R12 pointing at Vector Reg save area  */
	addi r12,r1,-224
				/* allocate stack frame  */
	stwux r1,r1,r11
				/* ...but return if HAS_VEC is zero   */
	beqlr

	/* We should really use VRSAVE to figure out which vector regs
	   we actually need to save and restore.  Some other time :-/  */

	li r11,-192
	stvx v20,r11,r12
	li r11,-176
	stvx v21,r11,r12
	li r11,-160
	stvx v22,r11,r12
	li r11,-144
	stvx v23,r11,r12
	li r11,-128
	stvx v24,r11,r12
	li r11,-112
	stvx v25,r11,r12
	li r11,-96
	stvx v26,r11,r12
	li r11,-80
	stvx v27,r11,r12
	li r11,-64
	stvx v28,r11,r12
	li r11,-48
	stvx v29,r11,r12
	li r11,-32
	stvx v30,r11,r12
	mfspr r0,VRsave
	li r11,-16
	stvx v31,r11,r12
				/* VRsave lives at -224(R1)  */
	stw r0,0(r12)
	blr


/* rest_world is jumped to, not called, so no need to worry about LR.
   No parameters, we return to the caller`s caller.  */

.private_extern rest_world
rest_world:
	bcl 20,31,Lr$pb
Lr$pb:	mflr r12
	lwz r11,0(r1)
				/* R11 := previous SP  */
	addis r12,r12,ha16(L_has_vec$non_lazy_ptr-Lr$pb)
	lwz r12,lo16(L_has_vec$non_lazy_ptr-Lr$pb)(r12)
	lwz r0,4(r11)
				/* R0 := old CR  */
	lwz r12,0(r12)
				/* R12 := HAS_VEC  */
	mtcr r0	
	cmpwi r12,0
	lmw r13,-220(r11)
	beq L.rest_world_fp
				/* restore VRsave and V20..V31  */
	lwz r0,-224(r11)
	li r12,-416
	mtspr VRsave,r0
	lvx v20,r11,r12
	li r12,-400
	lvx v21,r11,r12
	li r12,-384
	lvx v22,r11,r12
	li r12,-368
	lvx v23,r11,r12
	li r12,-352
	lvx v24,r11,r12
	li r12,-336
	lvx v25,r11,r12
	li r12,-320
	lvx v26,r11,r12
	li r12,-304
	lvx v27,r11,r12
	li r12,-288
	lvx v28,r11,r12
	li r12,-272
	lvx v29,r11,r12
	li r12,-256
	lvx v30,r11,r12
	li r12,-240
	lvx v31,r11,r12

L.rest_world_fp:
				/* grab original LR in R0  */
	lwz r0, 8(r11)
	lfd f14,-144(r11)
	lfd f15,-136(r11)
	lfd f16,-128(r11)
	lfd f17,-120(r11)
	lfd f18,-112(r11)
	lfd f19,-104(r11)
	lfd f20,-96(r11)
	lfd f21,-88(r11)
	lfd f22,-80(r11)
	lfd f23,-72(r11)
	lfd f24,-64(r11)
	lfd f25,-56(r11)
	lfd f26,-48(r11)
	lfd f27,-40(r11)
	lfd f28,-32(r11)
	lfd f29,-24(r11)
	lfd f30,-16(r11)
	mtlr r0
	lfd f31,-8(r11)
				/* set SP to original value  */
	mr r1,r11
	blr
