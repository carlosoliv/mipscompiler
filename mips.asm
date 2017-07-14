mdc_entry:
	move $fp, $sp
	sw $ra, 0($sp)
	addiu $sp, $sp, -4
	lw $ra, 4($sp)
	addiu $sp, $sp 0
	lw $fp, 0($sp)
	jr $ra
sw $a0, 0($sp)
addiu $sp, $sp, -4
		b func0_end_if
func_0_true:
	func_0_end_if:
li $r0 a
li $r1 b
li $r2 b
li $r3 b
li $r4 a
li $r5 b
mod_entry:
	move $fp, $sp
	sw $ra, 0($sp)
	addiu $sp, $sp, -4
	lw $ra, 4($sp)
	addiu $sp, $sp 0
	lw $fp, 0($sp)
	jr $ra
sw $a0, 0($sp)
addiu $sp, $sp, -4
		b func1_end_if
func_1_true:
	func_1_end_if:
li $r6 a
li $r7 b
li $r8 a
sw $a0, 0($sp)
addiu $sp, $sp - 4
li $r9 a
li $r10 b
li $r11 b
