// Generated from grammar/EightBit.g4 by ANTLR 4.5.3
package eightBit.compile;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EightBitParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, NUMBER=19, STRING=20, NOT=21, EQ=22, NEQ=23, LEQ=24, OR=25, 
		TRUE=26, FALSE=27, MUL=28, DIV=29, ADD=30, SUB=31, ID=32, SLC=33, MLC=34, 
		WS=35;
	public static final int
		RULE_eightProgram = 0, RULE_eightFunction = 1, RULE_formals = 2, RULE_idList = 3, 
		RULE_id = 4, RULE_funBody = 5, RULE_emptyStatement = 6, RULE_letStatement = 7, 
		RULE_assignStmtList = 8, RULE_closedStatement = 9, RULE_varAssignStatement = 10, 
		RULE_assignStatement = 11, RULE_whileStatement = 12, RULE_ifStatement = 13, 
		RULE_callStatement = 14, RULE_returnStatement = 15, RULE_blockStatement = 16, 
		RULE_closedList = 17, RULE_expr = 18, RULE_relMonom = 19, RULE_relOperation = 20, 
		RULE_relOperator = 21, RULE_arithOperation = 22, RULE_arithMonom = 23, 
		RULE_arithSingle = 24, RULE_operTDArithSingle = 25, RULE_constant = 26, 
		RULE_arguments = 27, RULE_args = 28;
	public static final String[] ruleNames = {
		"eightProgram", "eightFunction", "formals", "idList", "id", "funBody", 
		"emptyStatement", "letStatement", "assignStmtList", "closedStatement", 
		"varAssignStatement", "assignStatement", "whileStatement", "ifStatement", 
		"callStatement", "returnStatement", "blockStatement", "closedList", "expr", 
		"relMonom", "relOperation", "relOperator", "arithOperation", "arithMonom", 
		"arithSingle", "operTDArithSingle", "constant", "arguments", "args"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fun'", "'('", "')'", "','", "';'", "'let'", "'{'", "'}'", "'='", 
		"'while'", "'if'", "'else'", "'return'", "'&&'", "'>'", "'<'", "'>='", 
		"'null'", null, null, "'!'", "'=='", "'!='", "'<='", "'||'", "'true'", 
		"'false'", "'*'", "'/'", "'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "NUMBER", "STRING", "NOT", "EQ", 
		"NEQ", "LEQ", "OR", "TRUE", "FALSE", "MUL", "DIV", "ADD", "SUB", "ID", 
		"SLC", "MLC", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "EightBit.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EightBitParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EightProgramContext extends ParserRuleContext {
		public List<EightFunctionContext> eightFunction() {
			return getRuleContexts(EightFunctionContext.class);
		}
		public EightFunctionContext eightFunction(int i) {
			return getRuleContext(EightFunctionContext.class,i);
		}
		public EightProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eightProgram; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitEightProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EightProgramContext eightProgram() throws RecognitionException {
		EightProgramContext _localctx = new EightProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_eightProgram);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(58);
				eightFunction();
				}
				}
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EightFunctionContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public FormalsContext formals() {
			return getRuleContext(FormalsContext.class,0);
		}
		public FunBodyContext funBody() {
			return getRuleContext(FunBodyContext.class,0);
		}
		public EightFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eightFunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitEightFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EightFunctionContext eightFunction() throws RecognitionException {
		EightFunctionContext _localctx = new EightFunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_eightFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__0);
			setState(64);
			id();
			setState(65);
			formals();
			setState(66);
			funBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalsContext extends ParserRuleContext {
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public FormalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formals; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitFormals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalsContext formals() throws RecognitionException {
		FormalsContext _localctx = new FormalsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_formals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(T__1);
			setState(70);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(69);
				idList();
				}
			}

			setState(72);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdListContext extends ParserRuleContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitIdList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_idList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			id();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(75);
				match(T__3);
				setState(76);
				id();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EightBitParser.ID, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunBodyContext extends ParserRuleContext {
		public LetStatementContext letStatement() {
			return getRuleContext(LetStatementContext.class,0);
		}
		public ClosedStatementContext closedStatement() {
			return getRuleContext(ClosedStatementContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public FunBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitFunBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunBodyContext funBody() throws RecognitionException {
		FunBodyContext _localctx = new FunBodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funBody);
		try {
			setState(87);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				letStatement();
				}
				break;
			case T__6:
			case T__9:
			case T__10:
			case T__12:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				closedStatement();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				emptyStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyStatementContext extends ParserRuleContext {
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LetStatementContext extends ParserRuleContext {
		public ClosedStatementContext closedStatement() {
			return getRuleContext(ClosedStatementContext.class,0);
		}
		public AssignStmtListContext assignStmtList() {
			return getRuleContext(AssignStmtListContext.class,0);
		}
		public LetStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitLetStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetStatementContext letStatement() throws RecognitionException {
		LetStatementContext _localctx = new LetStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_letStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__5);
			setState(92);
			match(T__6);
			setState(94);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(93);
				assignStmtList();
				}
			}

			setState(96);
			match(T__7);
			setState(97);
			closedStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignStmtListContext extends ParserRuleContext {
		public List<VarAssignStatementContext> varAssignStatement() {
			return getRuleContexts(VarAssignStatementContext.class);
		}
		public VarAssignStatementContext varAssignStatement(int i) {
			return getRuleContext(VarAssignStatementContext.class,i);
		}
		public AssignStmtListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmtList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitAssignStmtList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStmtListContext assignStmtList() throws RecognitionException {
		AssignStmtListContext _localctx = new AssignStmtListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignStmtList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			varAssignStatement();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(100);
				match(T__4);
				setState(101);
				varAssignStatement();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClosedStatementContext extends ParserRuleContext {
		public AssignStatementContext assignStatement() {
			return getRuleContext(AssignStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public CallStatementContext callStatement() {
			return getRuleContext(CallStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public ClosedStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closedStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitClosedStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClosedStatementContext closedStatement() throws RecognitionException {
		ClosedStatementContext _localctx = new ClosedStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_closedStatement);
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				assignStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				whileStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(110);
				callStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(111);
				returnStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(112);
				blockStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarAssignStatementContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarAssignStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varAssignStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitVarAssignStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarAssignStatementContext varAssignStatement() throws RecognitionException {
		VarAssignStatementContext _localctx = new VarAssignStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_varAssignStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			id();
			setState(116);
			match(T__8);
			setState(117);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignStatementContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitAssignStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStatementContext assignStatement() throws RecognitionException {
		AssignStatementContext _localctx = new AssignStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			id();
			setState(120);
			match(T__8);
			setState(121);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ClosedStatementContext closedStatement() {
			return getRuleContext(ClosedStatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(T__9);
			setState(124);
			match(T__1);
			setState(125);
			expr();
			setState(126);
			match(T__2);
			setState(127);
			closedStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<ClosedStatementContext> closedStatement() {
			return getRuleContexts(ClosedStatementContext.class);
		}
		public ClosedStatementContext closedStatement(int i) {
			return getRuleContext(ClosedStatementContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(T__10);
			setState(130);
			match(T__1);
			setState(131);
			expr();
			setState(132);
			match(T__2);
			setState(133);
			closedStatement();
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(134);
				match(T__11);
				setState(135);
				closedStatement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallStatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EightBitParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public CallStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallStatementContext callStatement() throws RecognitionException {
		CallStatementContext _localctx = new CallStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_callStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(ID);
			setState(139);
			arguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__12);
			setState(142);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public ClosedListContext closedList() {
			return getRuleContext(ClosedListContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(T__6);
			setState(146);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << ID))) != 0)) {
				{
				setState(145);
				closedList();
				}
			}

			setState(148);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClosedListContext extends ParserRuleContext {
		public List<ClosedStatementContext> closedStatement() {
			return getRuleContexts(ClosedStatementContext.class);
		}
		public ClosedStatementContext closedStatement(int i) {
			return getRuleContext(ClosedStatementContext.class,i);
		}
		public ClosedListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closedList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitClosedList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClosedListContext closedList() throws RecognitionException {
		ClosedListContext _localctx = new ClosedListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_closedList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			closedStatement();
			setState(152);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(151);
				match(T__4);
				}
			}

			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << ID))) != 0)) {
				{
				{
				setState(154);
				closedStatement();
				setState(156);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(155);
					match(T__4);
					}
				}

				}
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<RelMonomContext> relMonom() {
			return getRuleContexts(RelMonomContext.class);
		}
		public RelMonomContext relMonom(int i) {
			return getRuleContext(RelMonomContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			relMonom();
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(164);
				match(OR);
				setState(165);
				relMonom();
				}
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelMonomContext extends ParserRuleContext {
		public List<RelOperationContext> relOperation() {
			return getRuleContexts(RelOperationContext.class);
		}
		public RelOperationContext relOperation(int i) {
			return getRuleContext(RelOperationContext.class,i);
		}
		public RelMonomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relMonom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitRelMonom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelMonomContext relMonom() throws RecognitionException {
		RelMonomContext _localctx = new RelMonomContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_relMonom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			relOperation();
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(172);
				match(T__13);
				setState(173);
				relOperation();
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelOperationContext extends ParserRuleContext {
		public List<ArithOperationContext> arithOperation() {
			return getRuleContexts(ArithOperationContext.class);
		}
		public ArithOperationContext arithOperation(int i) {
			return getRuleContext(ArithOperationContext.class,i);
		}
		public List<RelOperatorContext> relOperator() {
			return getRuleContexts(RelOperatorContext.class);
		}
		public RelOperatorContext relOperator(int i) {
			return getRuleContext(RelOperatorContext.class,i);
		}
		public RelOperationContext relOperation() {
			return getRuleContext(RelOperationContext.class,0);
		}
		public RelOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relOperation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitRelOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelOperationContext relOperation() throws RecognitionException {
		RelOperationContext _localctx = new RelOperationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_relOperation);
		int _la;
		try {
			setState(190);
			switch (_input.LA(1)) {
			case T__1:
			case T__17:
			case NUMBER:
			case STRING:
			case TRUE:
			case FALSE:
			case SUB:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				arithOperation();
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << EQ) | (1L << NEQ) | (1L << LEQ))) != 0)) {
					{
					{
					setState(180);
					relOperator();
					setState(181);
					arithOperation();
					}
					}
					setState(187);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				match(NOT);
				setState(189);
				relOperation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelOperatorContext extends ParserRuleContext {
		public RelOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitRelOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelOperatorContext relOperator() throws RecognitionException {
		RelOperatorContext _localctx = new RelOperatorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_relOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << EQ) | (1L << NEQ) | (1L << LEQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithOperationContext extends ParserRuleContext {
		public Token oper;
		public List<ArithMonomContext> arithMonom() {
			return getRuleContexts(ArithMonomContext.class);
		}
		public ArithMonomContext arithMonom(int i) {
			return getRuleContext(ArithMonomContext.class,i);
		}
		public ArithOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithOperation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitArithOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithOperationContext arithOperation() throws RecognitionException {
		ArithOperationContext _localctx = new ArithOperationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_arithOperation);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			arithMonom();
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					{
					setState(195);
					((ArithOperationContext)_localctx).oper = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUB) ) {
						((ArithOperationContext)_localctx).oper = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					setState(196);
					arithMonom();
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithMonomContext extends ParserRuleContext {
		public ArithSingleContext arithSingle() {
			return getRuleContext(ArithSingleContext.class,0);
		}
		public List<OperTDArithSingleContext> operTDArithSingle() {
			return getRuleContexts(OperTDArithSingleContext.class);
		}
		public OperTDArithSingleContext operTDArithSingle(int i) {
			return getRuleContext(OperTDArithSingleContext.class,i);
		}
		public ArithMonomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithMonom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitArithMonom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithMonomContext arithMonom() throws RecognitionException {
		ArithMonomContext _localctx = new ArithMonomContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_arithMonom);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			arithSingle();
			setState(206);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(203);
					operTDArithSingle();
					}
					} 
				}
				setState(208);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithSingleContext extends ParserRuleContext {
		public ArithSingleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithSingle; }
	 
		public ArithSingleContext() { }
		public void copyFrom(ArithSingleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArithParsSingleContext extends ArithSingleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArithParsSingleContext(ArithSingleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitArithParsSingle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithMinusSingleContext extends ArithSingleContext {
		public ArithOperationContext arithOperation() {
			return getRuleContext(ArithOperationContext.class,0);
		}
		public ArithMinusSingleContext(ArithSingleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitArithMinusSingle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithIdSingleContext extends ArithSingleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ArithIdSingleContext(ArithSingleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitArithIdSingle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithConstantSingleContext extends ArithSingleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ArithConstantSingleContext(ArithSingleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitArithConstantSingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithSingleContext arithSingle() throws RecognitionException {
		ArithSingleContext _localctx = new ArithSingleContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_arithSingle);
		int _la;
		try {
			setState(220);
			switch (_input.LA(1)) {
			case SUB:
				_localctx = new ArithMinusSingleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				match(SUB);
				setState(210);
				arithOperation();
				}
				break;
			case T__1:
				_localctx = new ArithParsSingleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				match(T__1);
				setState(212);
				expr();
				setState(213);
				match(T__2);
				}
				break;
			case ID:
				_localctx = new ArithIdSingleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				id();
				setState(217);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(216);
					arguments();
					}
				}

				}
				break;
			case T__17:
			case NUMBER:
			case STRING:
			case TRUE:
			case FALSE:
				_localctx = new ArithConstantSingleContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(219);
				constant();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperTDArithSingleContext extends ParserRuleContext {
		public Token oper;
		public ArithSingleContext arithSingle() {
			return getRuleContext(ArithSingleContext.class,0);
		}
		public OperTDArithSingleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operTDArithSingle; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitOperTDArithSingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperTDArithSingleContext operTDArithSingle() throws RecognitionException {
		OperTDArithSingleContext _localctx = new OperTDArithSingleContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_operTDArithSingle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(222);
			((OperTDArithSingleContext)_localctx).oper = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==MUL || _la==DIV) ) {
				((OperTDArithSingleContext)_localctx).oper = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
			setState(223);
			arithSingle();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	 
		public ConstantContext() { }
		public void copyFrom(ConstantContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprNumContext extends ConstantContext {
		public TerminalNode NUMBER() { return getToken(EightBitParser.NUMBER, 0); }
		public ExprNumContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitExprNum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprStringContext extends ConstantContext {
		public TerminalNode STRING() { return getToken(EightBitParser.STRING, 0); }
		public ExprStringContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitExprString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprFalseContext extends ConstantContext {
		public ExprFalseContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitExprFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprTrueContext extends ConstantContext {
		public ExprTrueContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitExprTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNullContext extends ConstantContext {
		public ExprNullContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitExprNull(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_constant);
		try {
			setState(230);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new ExprNumContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				match(NUMBER);
				}
				break;
			case STRING:
				_localctx = new ExprStringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				match(STRING);
				}
				break;
			case TRUE:
				_localctx = new ExprTrueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new ExprFalseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(228);
				match(FALSE);
				}
				break;
			case T__17:
				_localctx = new ExprNullContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(229);
				match(T__17);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(T__1);
			setState(234);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__17) | (1L << NUMBER) | (1L << STRING) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << SUB) | (1L << ID))) != 0)) {
				{
				setState(233);
				args();
				}
			}

			setState(236);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EightBitVisitor ) return ((EightBitVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			expr();
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(239);
				match(T__3);
				setState(240);
				expr();
				}
				}
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3%\u00f9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\6\2>\n\2\r\2\16"+
		"\2?\3\3\3\3\3\3\3\3\3\3\3\4\3\4\5\4I\n\4\3\4\3\4\3\5\3\5\3\5\7\5P\n\5"+
		"\f\5\16\5S\13\5\3\6\3\6\3\7\3\7\3\7\5\7Z\n\7\3\b\3\b\3\t\3\t\3\t\5\ta"+
		"\n\t\3\t\3\t\3\t\3\n\3\n\3\n\7\ni\n\n\f\n\16\nl\13\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\5\13t\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u008b\n\17\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\22\3\22\5\22\u0095\n\22\3\22\3\22\3\23\3\23"+
		"\5\23\u009b\n\23\3\23\3\23\5\23\u009f\n\23\7\23\u00a1\n\23\f\23\16\23"+
		"\u00a4\13\23\3\24\3\24\3\24\7\24\u00a9\n\24\f\24\16\24\u00ac\13\24\3\25"+
		"\3\25\3\25\7\25\u00b1\n\25\f\25\16\25\u00b4\13\25\3\26\3\26\3\26\3\26"+
		"\7\26\u00ba\n\26\f\26\16\26\u00bd\13\26\3\26\3\26\5\26\u00c1\n\26\3\27"+
		"\3\27\3\30\3\30\3\30\7\30\u00c8\n\30\f\30\16\30\u00cb\13\30\3\31\3\31"+
		"\7\31\u00cf\n\31\f\31\16\31\u00d2\13\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\5\32\u00dc\n\32\3\32\5\32\u00df\n\32\3\33\3\33\3\33\3\34\3"+
		"\34\3\34\3\34\3\34\5\34\u00e9\n\34\3\35\3\35\5\35\u00ed\n\35\3\35\3\35"+
		"\3\36\3\36\3\36\7\36\u00f4\n\36\f\36\16\36\u00f7\13\36\3\36\2\2\37\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:\2\5\4\2\21"+
		"\23\30\32\3\2 !\3\2\36\37\u00fc\2=\3\2\2\2\4A\3\2\2\2\6F\3\2\2\2\bL\3"+
		"\2\2\2\nT\3\2\2\2\fY\3\2\2\2\16[\3\2\2\2\20]\3\2\2\2\22e\3\2\2\2\24s\3"+
		"\2\2\2\26u\3\2\2\2\30y\3\2\2\2\32}\3\2\2\2\34\u0083\3\2\2\2\36\u008c\3"+
		"\2\2\2 \u008f\3\2\2\2\"\u0092\3\2\2\2$\u0098\3\2\2\2&\u00a5\3\2\2\2(\u00ad"+
		"\3\2\2\2*\u00c0\3\2\2\2,\u00c2\3\2\2\2.\u00c4\3\2\2\2\60\u00cc\3\2\2\2"+
		"\62\u00de\3\2\2\2\64\u00e0\3\2\2\2\66\u00e8\3\2\2\28\u00ea\3\2\2\2:\u00f0"+
		"\3\2\2\2<>\5\4\3\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\3\3\2\2\2"+
		"AB\7\3\2\2BC\5\n\6\2CD\5\6\4\2DE\5\f\7\2E\5\3\2\2\2FH\7\4\2\2GI\5\b\5"+
		"\2HG\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JK\7\5\2\2K\7\3\2\2\2LQ\5\n\6\2MN\7\6"+
		"\2\2NP\5\n\6\2OM\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\t\3\2\2\2SQ\3"+
		"\2\2\2TU\7\"\2\2U\13\3\2\2\2VZ\5\20\t\2WZ\5\24\13\2XZ\5\16\b\2YV\3\2\2"+
		"\2YW\3\2\2\2YX\3\2\2\2Z\r\3\2\2\2[\\\7\7\2\2\\\17\3\2\2\2]^\7\b\2\2^`"+
		"\7\t\2\2_a\5\22\n\2`_\3\2\2\2`a\3\2\2\2ab\3\2\2\2bc\7\n\2\2cd\5\24\13"+
		"\2d\21\3\2\2\2ej\5\26\f\2fg\7\7\2\2gi\5\26\f\2hf\3\2\2\2il\3\2\2\2jh\3"+
		"\2\2\2jk\3\2\2\2k\23\3\2\2\2lj\3\2\2\2mt\5\30\r\2nt\5\32\16\2ot\5\34\17"+
		"\2pt\5\36\20\2qt\5 \21\2rt\5\"\22\2sm\3\2\2\2sn\3\2\2\2so\3\2\2\2sp\3"+
		"\2\2\2sq\3\2\2\2sr\3\2\2\2t\25\3\2\2\2uv\5\n\6\2vw\7\13\2\2wx\5&\24\2"+
		"x\27\3\2\2\2yz\5\n\6\2z{\7\13\2\2{|\5&\24\2|\31\3\2\2\2}~\7\f\2\2~\177"+
		"\7\4\2\2\177\u0080\5&\24\2\u0080\u0081\7\5\2\2\u0081\u0082\5\24\13\2\u0082"+
		"\33\3\2\2\2\u0083\u0084\7\r\2\2\u0084\u0085\7\4\2\2\u0085\u0086\5&\24"+
		"\2\u0086\u0087\7\5\2\2\u0087\u008a\5\24\13\2\u0088\u0089\7\16\2\2\u0089"+
		"\u008b\5\24\13\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\35\3\2"+
		"\2\2\u008c\u008d\7\"\2\2\u008d\u008e\58\35\2\u008e\37\3\2\2\2\u008f\u0090"+
		"\7\17\2\2\u0090\u0091\5&\24\2\u0091!\3\2\2\2\u0092\u0094\7\t\2\2\u0093"+
		"\u0095\5$\23\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\u0097\7\n\2\2\u0097#\3\2\2\2\u0098\u009a\5\24\13\2\u0099\u009b"+
		"\7\7\2\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u00a2\3\2\2\2\u009c"+
		"\u009e\5\24\13\2\u009d\u009f\7\7\2\2\u009e\u009d\3\2\2\2\u009e\u009f\3"+
		"\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009c\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3%\3\2\2\2\u00a4\u00a2\3\2\2\2"+
		"\u00a5\u00aa\5(\25\2\u00a6\u00a7\7\33\2\2\u00a7\u00a9\5(\25\2\u00a8\u00a6"+
		"\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\'\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00b2\5*\26\2\u00ae\u00af\7\20\2"+
		"\2\u00af\u00b1\5*\26\2\u00b0\u00ae\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0"+
		"\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3)\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5"+
		"\u00bb\5.\30\2\u00b6\u00b7\5,\27\2\u00b7\u00b8\5.\30\2\u00b8\u00ba\3\2"+
		"\2\2\u00b9\u00b6\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u00c1\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\7\27"+
		"\2\2\u00bf\u00c1\5*\26\2\u00c0\u00b5\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1"+
		"+\3\2\2\2\u00c2\u00c3\t\2\2\2\u00c3-\3\2\2\2\u00c4\u00c9\5\60\31\2\u00c5"+
		"\u00c6\t\3\2\2\u00c6\u00c8\5\60\31\2\u00c7\u00c5\3\2\2\2\u00c8\u00cb\3"+
		"\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca/\3\2\2\2\u00cb\u00c9"+
		"\3\2\2\2\u00cc\u00d0\5\62\32\2\u00cd\u00cf\5\64\33\2\u00ce\u00cd\3\2\2"+
		"\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\61"+
		"\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4\7!\2\2\u00d4\u00df\5.\30\2\u00d5"+
		"\u00d6\7\4\2\2\u00d6\u00d7\5&\24\2\u00d7\u00d8\7\5\2\2\u00d8\u00df\3\2"+
		"\2\2\u00d9\u00db\5\n\6\2\u00da\u00dc\58\35\2\u00db\u00da\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00df\5\66\34\2\u00de\u00d3\3"+
		"\2\2\2\u00de\u00d5\3\2\2\2\u00de\u00d9\3\2\2\2\u00de\u00dd\3\2\2\2\u00df"+
		"\63\3\2\2\2\u00e0\u00e1\t\4\2\2\u00e1\u00e2\5\62\32\2\u00e2\65\3\2\2\2"+
		"\u00e3\u00e9\7\25\2\2\u00e4\u00e9\7\26\2\2\u00e5\u00e9\7\34\2\2\u00e6"+
		"\u00e9\7\35\2\2\u00e7\u00e9\7\24\2\2\u00e8\u00e3\3\2\2\2\u00e8\u00e4\3"+
		"\2\2\2\u00e8\u00e5\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9"+
		"\67\3\2\2\2\u00ea\u00ec\7\4\2\2\u00eb\u00ed\5:\36\2\u00ec\u00eb\3\2\2"+
		"\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\7\5\2\2\u00ef9"+
		"\3\2\2\2\u00f0\u00f5\5&\24\2\u00f1\u00f2\7\6\2\2\u00f2\u00f4\5&\24\2\u00f3"+
		"\u00f1\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2"+
		"\2\2\u00f6;\3\2\2\2\u00f7\u00f5\3\2\2\2\31?HQY`js\u008a\u0094\u009a\u009e"+
		"\u00a2\u00aa\u00b2\u00bb\u00c0\u00c9\u00d0\u00db\u00de\u00e8\u00ec\u00f5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}